package mapping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import talk.account.service.impl.AccountServiceImplService;
import talk.account.service.impl.AccountServiceImplServiceLocator;
import talk.account.service.impl.AccountServiceImplServicePortType;
import talk.calling.service.impl.CallingServiceImplService;
import talk.calling.service.impl.CallingServiceImplServiceLocator;
import talk.calling.service.impl.CallingServiceImplServicePortType;
import talk.calling.service.xsd.MappingPhone;

/**
 * Servlet implementation class MappingServlet
 */
public class MappingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MappingServlet() {
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
		
		HttpSession session = request.getSession();
		String sid = null;
		if(session.getAttribute("sid") != null){
			sid = (String) session.getAttribute("sid");
		}
		
		String action = request.getParameter("action");
		String phone = request.getParameter("userphone");
		String inputPassword = request.getParameter("inputPassword");
		System.out.println("action=" + action + ",userphone=" + phone + ",inputPassword=" + inputPassword);
		
		//建立webservice物件
		AccountServiceImplService accountService = new AccountServiceImplServiceLocator();
		AccountServiceImplServicePortType accountPort = null;
		CallingServiceImplService callService = new CallingServiceImplServiceLocator();
		CallingServiceImplServicePortType callPort = null;
		String resStr = null;
		
		if("sendMessage".equals(action)){
			//寄送簡訊驗證碼
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.createUserforMappingService(phone);
				System.out.println("in send message action response string = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if("FAILED Not MVPN".equals(resStr)){
				response.setContentType("text/html;charset=UTF-8");
		        response.getWriter().write("noMVPN");
			}else if("SUCCESS".equals(resStr)){
				response.setContentType("text/html;charset=UTF-8");
		        response.getWriter().write("success");
			}else if("Duplicated User".equals(resStr)){
				response.setContentType("text/html;charset=UTF-8");
		        response.getWriter().write("duplicate");
			}
			
		}else if("forgotPwd".equals(action)){
			//忘記密碼
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.resendOfflinePassword(phone);
				System.out.println("in forgot password action response string = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if("FAILED Not MVPN".equals(resStr)){
				response.setContentType("text/html;charset=UTF-8");
		        response.getWriter().write("noMVPN");
			}else if("SUCCESS".equals(resStr)){
				response.setContentType("text/html;charset=UTF-8");
		        response.getWriter().write("success");
			}else if("Duplicated User".equals(resStr)){
				response.setContentType("text/html;charset=UTF-8");
		        response.getWriter().write("duplicate");
			}
		}else if("login".equals(action)){
			//登入
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.loginMappingService(phone, inputPassword);
				System.out.println("in login action response string = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
						
			//登入成功，將session id、userphone、pws放入session
			if(resStr.startsWith("sid")){
				sid = resStr;
				session.setAttribute("sid", sid);
				session.setAttribute("userphone", phone);
				session.setAttribute("oldPassword", inputPassword);
				//取得使用者Mapping List
				MappingPhone[] mappedList = null;
				String[] mappingList = null;
				try {
					callPort = callService.getCallingServiceImplServiceHttpSoap11Endpoint();
					mappingList = callPort.getMappingList(sid);
					mappedList = callPort.getMappedList(sid);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				/*
				if(mappedList != null){
					for(int i = 0; i < mappedList.length; i++){
						System.out.println("mapped=" + mappedList[i].getMappingNumber() + " <> " + mappedList[i].getNumber());
					}
				}
				if(mappingList != null){
					for(int i = 0; i < mappingList.length; i++){
						System.out.println("mapping=" + mappingList[i]);
					}
				}
				*/
				request.setAttribute("mappingList", mappingList);
				request.setAttribute("mappedList", mappedList);
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/mappingList.jsp");
				dis.forward(request, response);
			//登入失敗
			}else if("FAILED No user".equals(resStr)){
				request.setAttribute("status", "nouser");
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/Home.jsp");
				dis.forward(request, response);
			}else if("FAILED Incorrect key".equals(resStr)){
				request.setAttribute("status", "incorrect");
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/Home.jsp");
				dis.forward(request, response);
			}else{
				request.setAttribute("status", "failed");
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/Home.jsp");
				dis.forward(request, response);
			}
		}else if("verify".equals(action)){
			//輸入簡訊驗證碼登入
			String verify = request.getParameter("verify");
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.loginMappingService(phone, verify);
				System.out.println("in verify action response string = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//簡訊驗證碼登入成功
			if(resStr.startsWith("sid")){
				sid = resStr;
				session.setAttribute("sid", sid);
				session.setAttribute("userphone", phone);
				request.setAttribute("verify", verify);
				request.setAttribute("status", "newUser");
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/setPwd.jsp");
				dis.forward(request, response);
			}else{
				request.setAttribute("status", "failed");
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/apply.jsp");
				dis.forward(request, response);
			}
		}else if("setPwd".equals(action)){
			//設定密碼
			String verify = request.getParameter("verify");
			System.out.println(sid + "," + verify + "," + inputPassword);
			MappingPhone[] mappedList = null;
			String[] mappingList = null;
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.chgUserPasswordforMappingService(sid, verify, inputPassword);
				System.out.println("in set password action response string = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				callPort = callService.getCallingServiceImplServiceHttpSoap11Endpoint();
				mappingList = callPort.getMappingList(sid);
				mappedList = callPort.getMappedList(sid);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("mappingList", mappingList);
			request.setAttribute("mappedList", mappedList);
			request.setAttribute("option", "forward");
			RequestDispatcher dis = request.getRequestDispatcher("/mappingList.jsp");
			dis.forward(request, response);
		}else if("chgPwd".equals(action)){
			//變更密碼
			String oldPassword = request.getParameter("oldPassword");
			System.out.println(sid + "," + oldPassword + "," + inputPassword);
			MappingPhone[] mappedList = null;
			String[] mappingList = null;
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.chgUserPasswordforMappingService(sid, oldPassword, inputPassword);
				System.out.println("in change password action response string = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				callPort = callService.getCallingServiceImplServiceHttpSoap11Endpoint();
				mappingList = callPort.getMappingList(sid);
				mappedList = callPort.getMappedList(sid);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("mappingList", mappingList);
			request.setAttribute("mappedList", mappedList);
			request.setAttribute("option", "forward");
			RequestDispatcher dis = request.getRequestDispatcher("/mappingList.jsp");
			dis.forward(request, response);
		}else if("getMappingList".equals(action)){
			String[] mappingList = null;
			MappingPhone[] mappedList = null;
			try {
				callPort = callService.getCallingServiceImplServiceHttpSoap11Endpoint();
				mappingList = callPort.getMappingList(sid);
				mappedList = callPort.getMappedList(sid);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*
			if(mappedList != null){
				for(int i = 0; i < mappedList.length; i++){
					System.out.println("mapped=" + mappedList[i].getMappingNumber() + " <> " + mappedList[i].getNumber());
				}
			}
			if(mappingList != null){
				for(int i = 0; i < mappingList.length; i++){
					System.out.println("mapping=" + mappingList[i]);
				}
			}
			*/
			request.setAttribute("mappingList", mappingList);
			request.setAttribute("mappedList", mappedList);
			request.setAttribute("option", "forward");
			RequestDispatcher dis = request.getRequestDispatcher("/mappingList.jsp");
			dis.forward(request, response);
		}else if("saveMappingList".equals(action)){
			//儲存Mapping List
			String[] mappingList = request.getParameterValues("mappingNum");
			String[] mappedPhone = request.getParameterValues("mappedPhone");
			String[] mappedName = request.getParameterValues("contact");
			ArrayList temp = new ArrayList();
			MappingPhone[] mappedList = null;
			MappingPhone newphone = null;
			
			//檢查配對號碼是否為MVPN
			String notMVPN = "";
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				if(mappedPhone != null){
					for(int i = 0; i < mappedPhone.length; i++){
						if(mappedPhone[i] != null && !"".equals(mappedPhone[i])){
							Boolean result = accountPort.checkMVPN(mappedPhone[i]);
							//System.out.println(mappedPhone[i] + " : " + result);
							if(!result){
								notMVPN += mappedPhone[i] + ",";
							}
						}
					}
				}				
			} catch (ServiceException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			System.out.println(notMVPN);
			String returnStr = null;
			if(notMVPN.length() > 0){
				notMVPN.substring(0, notMVPN.length()-1);
				returnStr = "nomvpn";
				try {
					callPort = callService.getCallingServiceImplServiceHttpSoap11Endpoint();
					mappingList = callPort.getMappingList(sid);
					mappedList = callPort.getMappedList(sid);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				//取得舊的配對清單
				MappingPhone[] oldMapped = null;
				try {
					callPort = callService.getCallingServiceImplServiceHttpSoap11Endpoint();
					oldMapped = callPort.getMappedList(sid);
				} catch (ServiceException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//舊配對清單的號碼
				String[] mappingNumLst = null;
				if(oldMapped != null){
					mappingNumLst = new String[oldMapped.length];
					for(int i = 0; i < oldMapped.length; i++){
						mappingNumLst[i] = oldMapped[i].getMappingNumber();
					}
				}
				//新的配對清單
				if(mappedPhone != null){
					for(int i = 0; i < mappedPhone.length; i++){
						//System.out.println(mappedName[i] + "," + mappedPhone[i]);
						if(mappedPhone[i] != null && !"".equals(mappedPhone[i])){
							newphone = new MappingPhone();
							newphone.setMappingNumber(mappingList[i]);
							newphone.setName(mappedName[i]);
							newphone.setNumber(mappedPhone[i]);
							temp.add(newphone);
						}
					}
				}
				mappedList = new MappingPhone[temp.size()];
				for(int i = 0; i < temp.size(); i++){
					mappedList[i] = (MappingPhone)temp.get(i);
				}
				
				try {
					callPort = callService.getCallingServiceImplServiceHttpSoap11Endpoint();
					//mappingNumber is system provide
					if(oldMapped != null){
						resStr = callPort.deleteMappingPhone(sid, mappingNumLst);
						System.out.println("in del mapping phone action response string = " + resStr);
					}
					resStr = callPort.addMappingPhone(sid, mappedList);
					System.out.println("in add mapping phone action response string = " + resStr);
					
					
					mappingList = callPort.getMappingList(sid);
					mappedList = callPort.getMappedList(sid);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if("SUCCESS".equals(resStr)){
					returnStr = "success";
				}else{
					returnStr = "failed";
				}
			}
			
			request.setAttribute("status", returnStr);
			request.setAttribute("numberStr", notMVPN);
			request.setAttribute("mappingList", mappingList);
			request.setAttribute("mappedList", mappedList);
			request.setAttribute("option", "forward");
			RequestDispatcher dis = request.getRequestDispatcher("/mappingList.jsp");
			dis.forward(request, response);
		}else if("logout".equals(action)){
			//登出
			try {
				accountPort = accountService.getAccountServiceImplServiceHttpSoap11Endpoint();
				resStr = accountPort.logout(sid);
				System.out.println("in logout action response string = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.invalidate();
			response.sendRedirect("Home.jsp");
		}
	}

}
