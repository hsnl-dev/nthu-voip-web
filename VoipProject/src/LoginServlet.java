

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import util.Admin;
import util.Authorization;
import util.KitsException;
import util.KitsStatus;
import util.Nation;
import util.User;
import util.UserManger;

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
		String phone = request.getParameter("userphone");
		String inputPassword = request.getParameter("inputPassword");
		System.out.println("action = " + action + ",phone=" + phone + ",pwd=" + inputPassword);
		
		HttpSession session = request.getSession();
		
		//建立webservice物件
		
		String resStr = null;
		
		if("login".equals(action)){
			//SuperUser登入
			if("super".equals(phone)){
				
				try {
					List<User> webUserList= Admin.getLeaderList();
					request.setAttribute("webUserList", webUserList);
					session.setAttribute("level", "0");
					request.setAttribute("option", "forward");
					RequestDispatcher dis = request.getRequestDispatcher("/applyManage1.jsp");
					dis.forward(request, response);
				} catch (KitsException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			}else{
				String level = null;
				String uuid = null;
				User userModel = null;
				//login with restful
				try {
					String token = Authorization.getToken(phone, inputPassword);
					session.setAttribute("token", token);
					//create user Model and set into session obj
					userModel = new User(token);
					userModel.updateInfo();
					level = userModel.getLevel();
					uuid = userModel.getAccountUuid();
					session.setAttribute("level", userModel.getLevel());
					session.setAttribute("cardId", userModel.getCardId());
					session.setAttribute("userphone", userModel.getUsename());
					session.setAttribute("accountUuid", userModel.getAccountUuid());
					session.setAttribute("oldPassword", inputPassword);		
					List<Nation> nationList = null;
					nationList = UserManger.getNation();
					session.setAttribute("nation", nationList);
					String unitName=null;
					if(userModel!=null){
						unitName = userModel.getUnitName();
					}
					//no unit name
					if(unitName == null | "".equals(unitName)){
						//new user
						session.setAttribute("newuser", "newuser");
						request.setAttribute("option", "forward");
						RequestDispatcher dis = request.getRequestDispatcher("/setUnitName.jsp");
						dis.forward(request, response);
					}else{ //have unit name
						//save unitname
						session.setAttribute("depart", unitName);
						response.sendRedirect("./contact.do");
					}
					
				}catch(KitsException  e){
					e.printStackTrace();
					if(KitsStatus.KITS_UNAUTHORIZED == e.getStatus()){
						System.out.println("password Error");
						request.setAttribute("status", "failed");
						request.setAttribute("option", "forward");
						RequestDispatcher dis = request.getRequestDispatcher("/Home1.jsp");
						dis.forward(request, response);
					}else if(KitsStatus.KITS_ACC_NOT_FOUND== e.getStatus()){
						request.setAttribute("status", "nouser");
						request.setAttribute("option", "forward");
						RequestDispatcher dis = request.getRequestDispatcher("/Home1.jsp");
						dis.forward(request, response);		
					}else{
						request.setAttribute("status", "error");
						request.setAttribute("option", "forward");
						RequestDispatcher dis = request.getRequestDispatcher("/Home1.jsp");
						dis.forward(request, response);
					}
				}catch (JSONException e){
					request.setAttribute("status", "error");
					request.setAttribute("option", "forward");
					RequestDispatcher dis = request.getRequestDispatcher("/Home1.jsp");
					dis.forward(request, response);
				}				
			}
		}else if("logout".equals(action)){
			//logout
			try {
				Authorization.delToken((String)session.getAttribute("token"));
			} catch (KitsException e) {
				e.printStackTrace();
			}
			session.invalidate();
			response.sendRedirect("Home1.jsp");
		}else if("super".equals(action)){
			try {
				List<User> webUserList= Admin.getLeaderList();
				request.setAttribute("webUserList", webUserList);
				session.setAttribute("level", "0");
				request.setAttribute("option", "forward");
				RequestDispatcher dis = request.getRequestDispatcher("/applyManage1.jsp");
				dis.forward(request, response);
			} catch (KitsException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
