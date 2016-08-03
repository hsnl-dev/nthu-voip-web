

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import talk.account.service.impl.AccountContactServiceImplService;
import talk.account.service.impl.AccountContactServiceImplServiceLocator;
import talk.account.service.impl.AccountContactServiceImplServicePortType;
import talk.account.service.impl.AccountServiceImplService;
import talk.account.service.impl.AccountServiceImplServiceLocator;
import talk.account.service.impl.AccountServiceImplServicePortType;
import talk.account.service.impl.SuperAccountServiceImpl;
import talk.account.service.impl.SuperAccountServiceImplLocator;
import talk.account.service.impl.SuperAccountServiceImplPortType;
import talk.account.service.xsd.UnitName;
import talk.account.service.xsd.WebAccount;
import talk.account.service.xsd.WebContact;
import talk.calling.service.impl.CallingServiceImplService;
import talk.calling.service.impl.CallingServiceImplServiceLocator;
import talk.calling.service.impl.CallingServiceImplServicePortType;
import talk.calling.service.xsd.MVPNHistory;
import util.MyComparator;
import util.Utility;

/**
 * Servlet implementation class WebUserServlet
 */
public class WebUserServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
    public WebUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		System.out.println("In WebUserSevlet~~");
		
		//輸入參數
		String action = request.getParameter("action");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String authCode = request.getParameter("authCode");
		//System.out.println(action);
		
		HttpSession session = request.getSession();
		//session id
		String sid = (String) session.getAttribute("sid");
		
		//新使用者
		String newuser = (String) session.getAttribute("newuser");
		
		//建立webservice物件
		AccountServiceImplService accountService = new AccountServiceImplServiceLocator();
		AccountServiceImplServicePortType accountPort = null;
		AccountContactServiceImplService contactService = new AccountContactServiceImplServiceLocator();
		AccountContactServiceImplServicePortType contactPort = null;
		SuperAccountServiceImpl superAccountService = new SuperAccountServiceImplLocator();
		SuperAccountServiceImplPortType superPort = null;
		String resStr = null;
		
		if("forgotPwd".equals(action)){
			//忘記密碼
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.resetPasswordMail(Utility.SYSTEMHANDSHAKE, phone);
				System.out.println("In forgot password, response = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String returnStr = "failed";
			String forwardUrl = "/forgot.jsp";
			if("SUCCESS".equals(resStr)){
				returnStr = "fotgotsuccess";
				forwardUrl = "/Home1.jsp";
			}
			request.setAttribute("status", returnStr);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher(forwardUrl);
			dis.forward(request, response);
		}else if("personalApply".equals(action)){
			//使用者申請
			
			try {
				superPort = superAccountService.getSuperAccountServiceImplHttpSoap11Endpoint();
				resStr = superPort.registerSuperAccount(email, phone, password);
				System.out.println("personal user apply, response = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = null;
			try {
				JSONObject json = new JSONObject(resStr);
				result = json.getString("status");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String returnStr = "failed";
			String forwardUrl = "/apply.jsp";
			if(result != null){
				if("SUCCESS".equals(result)){
					returnStr = "applysuccess";
					forwardUrl = "/login.jsp";
				}else if(result.startsWith("FAILED")){
					returnStr = "insufficient";
				}else if(result.startsWith("Duplicated")){
					returnStr = "duplicate";
				}
			}
			
			request.setAttribute("status", returnStr);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher(forwardUrl);
			dis.forward(request, response);
		}else if("verify".equals(action)){
			//驗證帳號
			try {
				System.out.println(email + "," + authCode);
				superPort = superAccountService.getSuperAccountServiceImplHttpSoap11Endpoint();
				resStr = superPort.validateSuperAccount(email, authCode);
				System.out.println("verify web user, response = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String result = null;
			try {
				JSONObject json = new JSONObject(resStr);
				result = json.getString("status");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if("SUCCESS".equals(result)){
				request.setAttribute("status", "verifysuccess");
			}else{
				request.setAttribute("status", "verifyfail");
			}
			request.setAttribute("option", "forward");
			RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
			dis.forward(request, response);
		}else if("changePassword".equals(action)){
			String oldPassword = (String) session.getAttribute("oldPassword");
			String inputPassword = request.getParameter("inputPassword");
			try {
				//修改密碼
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.chgWebUserPassword(sid, oldPassword, inputPassword);
				System.out.println("change password, response = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("option", "forward");
			RequestDispatcher dis = request.getRequestDispatcher("/contact.do");
			dis.forward(request, response);
		}else if("newPhone".equals(action)){
			//新增可接聽的電話號碼至號碼清單
			try {
				superPort = superAccountService.getSuperAccountServiceImplHttpSoap11Endpoint();
				resStr = superPort.addPhone(sid, phone);
				System.out.println("in new phone phone = " + phone + ", and response = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = null;
			try {
				JSONObject json = new JSONObject(resStr);
				result = json.getString("status");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if("FAILED Insufficient information".equals(result)){
				request.setAttribute("status", "insufficient");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				dis.forward(request, response);
			}else if("FAILED Incorrect session".equals(result)){
				request.setAttribute("status", "incorrectSession");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				dis.forward(request, response);
			}else if("FAILED Duplicate record".equals(result)){
				request.setAttribute("status", "DRecord");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				dis.forward(request, response);
			}else if("SUCCESS".equals(result)){
				resStr = superPort.getSuperAccountInfo(sid);
				String[] phoneList = null;
				try {
					JSONObject json = new JSONObject(resStr);
					result = json.getString("status");
					if("SUCCESS".equals(result)){
						JSONArray phoneAry = json.getJSONArray("phoneList");
						phoneList = new String[phoneAry.length()];
						for(int i = 0; i < phoneAry.length(); i++){
							phoneList[i] = phoneAry.getString(i);
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session.setAttribute("phoneList", phoneList);
				
				request.setAttribute("status", "newSuccess");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				dis.forward(request, response);
			}else{
				request.setAttribute("status", "error");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				dis.forward(request, response);
			}
		}else if("setPhone".equals(action)){
			String selectPhone = request.getParameter("selectPhone");
			//設定接聽的電話號碼
			try {
				//設定接聽的電話號碼
				superPort = superAccountService.getSuperAccountServiceImplHttpSoap11Endpoint();
				resStr = superPort.setCurrentPhone(sid, selectPhone);
				System.out.println("in set phone select phone = " + selectPhone + ", and response = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String result = null;
			try {
				JSONObject json = new JSONObject(resStr);
				result = json.getString("status");
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if("FAILED Insufficient information".equals(result)){
				request.setAttribute("status", "insufficient");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				dis.forward(request, response);
			}else if("FAILED Incorrect session".equals(result)){
				request.setAttribute("status", "incorrectSession");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				dis.forward(request, response);
			}else if("FAILED No record".equals(result)){
				request.setAttribute("status", "noRecord");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				dis.forward(request, response);
			}else if("SUCCESS".equals(result)){
				session.setAttribute("userphone", selectPhone);
				
				WebContact[] contactList = null;
				try {
					contactPort = contactService.getAccountContactServiceImplServiceHttpSoap11Endpoint();
					contactList = contactPort.getWebContactList(sid);
					
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(contactList != null){
					Arrays.sort(contactList, new MyComparator());
				}
				
				request.setAttribute("contactList", contactList);
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/contactList1.jsp");
				dis.forward(request, response);
			}else{
				request.setAttribute("status", "error");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				dis.forward(request, response);
			}
		}
	}

}
