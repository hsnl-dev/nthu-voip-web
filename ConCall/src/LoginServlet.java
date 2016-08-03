

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
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
import talk.account.service.xsd.WebAccount;
import talk.account.service.xsd.WebContact;
import talk.calling.service.impl.CallingServiceImplService;
import talk.calling.service.impl.CallingServiceImplServiceLocator;
import talk.calling.service.impl.CallingServiceImplServicePortType;
import talk.calling.service.xsd.MVPNHistory;
import talk.calling.service.xsd.NationalCode;
import util.MyComparator;
import util.Utility;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		System.out.println("in login servlet");
		
		//輸入參數
		String action = request.getParameter("action");
		String email = request.getParameter("email");
		String inputPassword = request.getParameter("inputPassword");
		System.out.println("action = " + action + ",email=" + email + ",pwd=" + inputPassword);
		
		HttpSession session = request.getSession();
		
		//建立webservice物件
		AccountServiceImplService accountService = new AccountServiceImplServiceLocator();
		AccountServiceImplServicePortType accountPort = null;
		SuperAccountServiceImpl superAccountService = new SuperAccountServiceImplLocator();
		SuperAccountServiceImplPortType superPort = null;
		AccountContactServiceImplService contactService = new AccountContactServiceImplServiceLocator();
		AccountContactServiceImplServicePortType contactPort = null;
		CallingServiceImplService callService = new CallingServiceImplServiceLocator();
		CallingServiceImplServicePortType callPort = null;
		String resStr = null;
		
		if("login".equals(action)){
			//登入系統
			try {
				superPort = superAccountService.getSuperAccountServiceImplHttpSoap11Endpoint();
				resStr = superPort.logingSuperAccount(email, inputPassword);
				System.out.println("In login web user response string = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String result = null;
			String sid = null;
			try {
				JSONObject json = new JSONObject(resStr);
				result = json.getString("status");
				if("SUCCESS".equals(result)){
					sid = json.getString("session");
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(result != null){
				if("FAILED No user".equals(result)){
					//登入失敗
					request.setAttribute("status", "nouser");
					request.setAttribute("option", "forward");
					RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
					dis.forward(request, response);
				}else if("FAILED Insufficient information".equals(result)){
					request.setAttribute("status", "insufficient");
					request.setAttribute("option", "forward");
					RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
					dis.forward(request, response);
				}else if("FAILED Incorrect password".equals(result)){
					request.setAttribute("status", "incorrectPassword");
					request.setAttribute("option", "forward");
					RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
					dis.forward(request, response);
				}else if("SUCCESS".equals(result)){
					//存session id, 使用者帳號(email)
					session.setAttribute("sid", sid);
					session.setAttribute("userEmail", email);
					
					//取得account info
					try {
						superPort = superAccountService.getSuperAccountServiceImplHttpSoap11Endpoint();
						resStr = superPort.getSuperAccountInfo(sid);
					} catch (ServiceException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					String phone = null;
					String[] phoneList = null;
					try {
						JSONObject json = new JSONObject(resStr);
						String getInfoStatus = json.getString("status");
						if("SUCCESS".equals(getInfoStatus)){
							phone = json.getString("currentPhone");
							JSONArray phoneAry = json.getJSONArray("phoneList");
							phoneList = new String[phoneAry.length()];
							for(int i = 0; i < phoneAry.length(); i++){
								phoneList[i] = phoneAry.getString(i);
							}
						}
					} catch (JSONException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					session.setAttribute("userphone", phone);
					session.setAttribute("oldPassword", inputPassword);
					session.setAttribute("phoneList", phoneList);
					
					//取得國碼
					NationalCode[] nation = null;
					try {
						callPort = callService.getCallingServiceImplServiceHttpSoap11Endpoint();
						nation = callPort.getNationalCode(Utility.SYSTEMHANDSHAKE);
					} catch (ServiceException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					session.setAttribute("nation", nation);
					
					//讀取聯絡人清單
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
					session.invalidate();
					request.setAttribute("status", "error");
					request.setAttribute("option", "forward");
					RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
					dis.forward(request, response);
				}
			
			}
		}else if("logout".equals(action)){
			//登出系統
			String sid = (String) session.getAttribute("sid");
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.logout(sid);
				System.out.println("In log out response string = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		
	}

}
