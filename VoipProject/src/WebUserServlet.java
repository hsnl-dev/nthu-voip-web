

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import util.Admin;
import util.KitsException;
import util.KitsStatus;
import util.Unit;
import util.User;
import util.UserManger;

/**
 * Servlet implementation class WebUserServlet
 */
public class WebUserServlet extends HttpServlet {
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
		String depart = request.getParameter("depart");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String authCode = request.getParameter("authCode");
		//System.out.println(action);
		
		HttpSession session = request.getSession();
		//session id
		String token = (String) session.getAttribute("token");
		
		//新使用者
		String newuser = (String) session.getAttribute("newuser");
		
		//建立webservice物件
		
		
		if("register".equals(action)){
			String returnStr = "failed";
			String forwardUrl = "/applyform.jsp";
			try {
				UserManger.regLeaderUser(email, phone,name,depart);
				returnStr = "register";
				forwardUrl = "/applyform.jsp";
			} catch (KitsException e1) {
				
				if(e1.getStatus() == KitsStatus.KITS_DUPLICATED){
					returnStr = "Duplicated";
				}else{
					returnStr = "failed";
					forwardUrl = "/applyform.jsp";
					e1.printStackTrace();
				}
			}

			request.setAttribute("status", returnStr);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher(forwardUrl);
			dis.forward(request, response);
		}else if("forgotPwd".equals(action)){
			String returnStr = null;
			String forwardUrl = null;
			try {
				UserManger.resetPassword(phone);
				returnStr = "fotgotsuccess";
				forwardUrl = "/Home1.jsp";
			} catch (KitsException e) {
				e.printStackTrace();
				returnStr = "failed";
				forwardUrl = "/forgot.jsp";
			}
			request.setAttribute("status", returnStr);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher(forwardUrl);
			dis.forward(request, response);
		}else if("apply".equals(action)){
			//導向一般使用者申請頁面
			List<Unit> unitlist;
			try {
				unitlist = UserManger.getUnitList();
			} catch (KitsException | JSONException e) {
				// TODO Auto-generated catch block
				unitlist = new ArrayList<Unit>();
				e.printStackTrace();
			}
			request.setAttribute("unitlist", unitlist);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/apply.jsp");
			dis.forward(request, response);
		}else if("personalApply".equals(action)){
			//一般使用者申請
			String unitId = request.getParameter("unitId");
			String returnStr;
			String forwardUrl; 
			try {
				UserManger.regPersonUser(email, phone, unitId, name);
				returnStr = "applysuccess";
				forwardUrl = "/Home1.jsp";
				
			} catch (KitsException e) {
				returnStr = "failed";
				forwardUrl = "/apply.jsp";
				e.printStackTrace();
			}
			request.setAttribute("status", returnStr);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher(forwardUrl);
			dis.forward(request, response);
		}else if("verify".equals(action)){

			
			
			//verify application of leader of department 
			try {
				UserManger.verifyUser(phone, authCode);
				request.setAttribute("status", "verifysuccess");
			} catch (KitsException e1) {
				request.setAttribute("status", "verifyfail");
				e1.printStackTrace();
			}
			
			request.setAttribute("option", "forward");
			RequestDispatcher dis = request.getRequestDispatcher("/Home1.jsp");
			dis.forward(request, response);
		}else if("approve".equals(action)){
			//approve application of leader of department 
			try {
				UserManger.approveUser(phone);
			} catch (KitsException e1) {
				e1.printStackTrace();
			}
			response.sendRedirect("./login.do?action=super");
		}else if("deny".equals(action)){
			
			//deny application of leader of department 
			try {
				UserManger.denyUser(phone);
			} catch (KitsException e1) {
				e1.printStackTrace();
			}
			response.sendRedirect("./login.do?action=super");
		}else if("deleteWebUser".equals(action)){
			//刪除單位管理者帳號以及管理者下所有附屬帳號!!!!
			try {
				UserManger.delUser(phone);
			} catch (KitsException e1) {
				e1.printStackTrace();
			}
			response.sendRedirect("./login.do?action=super");
			
		}else if("sendmail".equals(action)){	
			// send verification mail restfull
			try {
				UserManger.sendVerificaion(phone);
			} catch (KitsException e) {
				e.printStackTrace();
			}
			response.sendRedirect("./login.do?action=super");
		}else if("applylist".equals(action)){
			//redirect to applylist.jsp
			try {
				List<User> webUserList= Admin.getLeaderList();
				request.setAttribute("webUserList", webUserList);
				session.setAttribute("level", "0");
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/applyList1.jsp");
				dis.forward(request, response);
			} catch (KitsException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}else if("setUnitName".equals(action)){
			
			
			//set unit name
			User user = new User(token);
			try {
				user.chgUnitName(depart);
			} catch (KitsException|IOException e) {
				System.out.println("chgUnitName ERROR");
				e.printStackTrace();
			}
			
			//存單位名稱
			session.setAttribute("depart", depart);
			//新使用者
			if("newuser".equals(newuser)){
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/newDefaultContact1.jsp");
				dis.forward(request, response);
			}else{ //非新使用者
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/applyList1.jsp");
				dis.forward(request, response);
			}
		}else if("changePassword".equals(action)){
			String oldPassword = (String) session.getAttribute("oldPassword");
			String inputPassword = request.getParameter("inputPassword");
			//change pass with rest
			User user = new User(token);
			try {
				user.chgWebUserPassword(oldPassword, inputPassword);
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/contact.do");
				dis.forward(request, response);
			} catch (KitsException|IOException e) {
				e.printStackTrace();
			}
			
		}else if("setPhone".equals(action)){
			//設定新分機號碼
			String returnStr = "";
			// change number with restful //
			User user = new User(token);
			try {
				user.chgUserName(phone);
				returnStr = "SUCCESS";
				//update session info
				User userModel = new User(token);
				userModel.updateInfo();
				session.setAttribute("level", userModel.getLevel());
				session.setAttribute("cardId", userModel.getCardId());
				session.setAttribute("userphone", userModel.getUsename());
				session.setAttribute("accountUuid", userModel.getAccountUuid());
				response.sendRedirect("./contact.do");
			} catch (KitsException e) {
				
				if(KitsStatus.KITS_DUPLICATED == e.getStatus()){
					returnStr = "Duplicated";
				}else{
					returnStr = "error";
					e.printStackTrace();
				}
				RequestDispatcher dis = request.getRequestDispatcher("/phone1.jsp");
				request.setAttribute("status", returnStr);
				dis.forward(request, response);
			}
			
		}
	}

}
