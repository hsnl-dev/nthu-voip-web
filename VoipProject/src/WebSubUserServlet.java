

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

import util.KitsException;
import util.SubUser;
import util.SubUserManager;
import util.User;
import util.UserManger;

/**
 * Servlet implementation class WebSubUserServlet
 */
public class WebSubUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebSubUserServlet() {
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
		
		System.out.println("in web sub user servlet~");
		
		//輸入參數
		String action = request.getParameter("action");
		String phone1 = request.getParameter("phone1");
		String useremail1 = request.getParameter("useremail1");
		String username = request.getParameter("username");
		String pointlimit = request.getParameter("pointlimit");
		String phone2 = request.getParameter("phone2");
		String useremail2 = request.getParameter("useremail2");
		System.out.println(action);
		System.out.println(phone1 + "," + useremail1 + "," + username + "," + pointlimit);
		
		HttpSession session = request.getSession();
		String level = (String) session.getAttribute("level");
	
		
		
	
		
		if("newSubUser".equals(action)){
			User user = new User((String)session.getAttribute("token"));
			try {
				user.updateInfo();
				//新增附屬帳號
				SubUser subUser1 = new SubUser();
				subUser1.setUsename(phone1);
				subUser1.setRegMail(useremail1);
				subUser1.setName(username);
				subUser1.setUnitName(user.getUnitUUID());
				subUser1.setLevel(1);
			
				List<SubUser> subUserList = new ArrayList<SubUser>();
				if(phone2 != null && !"".equals(phone2) && useremail2 != null && !"".equals(useremail2)){
					SubUser subUser2 = new SubUser();
					subUser2.setUsename(phone2);
					subUser2.setRegMail(useremail2);
					subUser1.setUnitName(user.getUnitUUID());
					subUser1.setLevel(1);
					subUserList.add(subUser1);
					subUserList.add(subUser2);
				}else{
					subUserList.add(subUser1);
				}
				SubUserManager sum = new SubUserManager((String)session.getAttribute("token"));
				sum.addSubUser(subUserList);
				
				
				System.out.println(subUserList.size());
				response.sendRedirect("./webSubUser.do?action=getSubUserList");
			} catch (KitsException | JSONException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				request.setAttribute("status", "error");
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/newSubUser1.jsp");
				dis.forward(request, response);
			}
			
		}else if("getSubUserList".equals(action)){
			//連到附屬帳號管理頁面
			String token = (String) session.getAttribute("token");
			Double userLimitPoint = null;
			Double userCurrentPoint = null;
			Double userInitPoint = null;
			Double userCostPoint = null;
			
			User usr = new User(token);
			SubUserManager sum = new SubUserManager(token);
			List<SubUser> subUserListNew = null;
			float totalPoint = 0.0f;
			
			try {
				//*get user point info 
				usr.updateInfo();
				userLimitPoint = usr.getLimitPoint();
				userCurrentPoint = usr.getCurrentPoint();
				userInitPoint = usr.getInitPoint();
				userCostPoint = usr.getCostPoint();
				//*get subuser info
				subUserListNew = sum.getAllSubUser();
				//*calculate total point
				for(SubUser oneUser:subUserListNew){
					//System.out.println(oneUser.getAccountUuid());
					if("0".equals(level)){
						if(oneUser.getLevel()==1){
							totalPoint += oneUser.getCurrentPoint();
						}
					}else{
						totalPoint += oneUser.getCurrentPoint();
					}
				}
				//*forward to view
				//System.out.println(userLimitPoint);
				//System.out.println(userCurrentPoint);
				//System.out.println(userInitPoint);
				//System.out.println(totalPoint);
				request.setAttribute("userLimitPoint", userLimitPoint);
				request.setAttribute("userCostPoint", userCostPoint);
				request.setAttribute("userCurrentPoint", userCurrentPoint);
				request.setAttribute("userInitPoint", userInitPoint);
				request.setAttribute("totalPoint", Float.toString(totalPoint));
				request.setAttribute("subUserListNew", subUserListNew);
				request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/accountManage1.jsp");
				dis.forward(request, response);
			} catch (KitsException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		
			
		}else if("updateLimit".equals(action)){
			String subUserUUID = request.getParameter("uuid");
			String phone = request.getParameter("subUser");
			String subUserName = request.getParameter("subUserName");
			String subUserEmail = request.getParameter("subUserEmail");
			String limit = request.getParameter("limit");
			
			SubUser account = new SubUser();
			account.setAccountUuid(subUserUUID);
			account.setUsename(phone);
			account.setName(subUserName);
			account.setRegMail(subUserEmail);

			session.setAttribute("subUserAccount", account);
			request.setAttribute("limit", limit);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/editSubUser.jsp");
			dis.forward(request, response);
		}else if("update".equals(action)){
			SubUser targetUser = (SubUser)session.getAttribute("subUserAccount");
			System.out.println(targetUser);
			targetUser.setName(username);
			targetUser.setRegMail(useremail1);
			SubUserManager sum = new SubUserManager((String)session.getAttribute("token"));
			
			try {
				sum.updateSubUserLimitPoint(targetUser, Float.parseFloat(pointlimit));
				//go to manage page
				response.sendRedirect("./webSubUser.do?action=getSubUserList");
			} catch (JSONException | KitsException e1) {
				response.sendError(500);
				e1.printStackTrace();
			}
		
			
			
			
		}else if("saveSubUser".equals(action)){
			String subUserUUID = request.getParameter("uuid");
			String uuidStr = request.getParameter("uuidStr");
			String[] uuidArr = null;
			if(uuidStr != null){
				System.out.println(subUserUUID + " : " + uuidStr);
				uuidStr.substring(0, uuidStr.length()-1);
				uuidArr = uuidStr.split(",");
			}
			try {
				//將第2層附屬帳號掛到第1層附屬帳號
				SubUserManager sum = new SubUserManager((String)session.getAttribute("token"));
				if(uuidArr != null){
					for(int i = 0; i < uuidArr.length; i++){
						sum.upgradeSubUser(uuidArr[i], subUserUUID);
					}
				}
				response.sendRedirect("./webSubUser.do?action=getSubUserList");
			} catch (JSONException | KitsException e) {
				e.printStackTrace();
			}
			
			
		}else if("levelup".equals(action)){
			String subUserUUID = request.getParameter("uuid");
			SubUserManager sum = new SubUserManager((String)session.getAttribute("token"));
			String accountUuid= (String)session.getAttribute("accountUuid");
			try {
				sum.upgradeSubUser(subUserUUID,accountUuid);
				response.sendRedirect("./webSubUser.do?action=getSubUserList");
			} catch (JSONException | KitsException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				response.sendError(500, "CloudServerError"+e2.getMessage());
			}
		}else if("degrade".equals(action)){
			String subUserUUID = request.getParameter("uuid");
			SubUserManager sum = new SubUserManager((String)session.getAttribute("token"));
			try {
				sum.downgradeSubUser(subUserUUID);
				response.sendRedirect("./webSubUser.do?action=getSubUserList");
			} catch (JSONException | KitsException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				response.sendError(500, "CloudServerError"+e2.getMessage());
			}
			
		}else if("changelevel1".equals(action)){
			String subUserUUID = request.getParameter("uuid");
			String newlevel1 = request.getParameter("uuidStr");
			SubUserManager sum = new SubUserManager((String)session.getAttribute("token"));
			
			if(newlevel1 != null){
				System.out.println(subUserUUID + " : " + newlevel1);
				newlevel1 = newlevel1.substring(0, newlevel1.length()-1);
			}
			//將第2層附屬帳號掛到新的第1層附屬帳號
			try {
				sum.upgradeSubUser(subUserUUID, newlevel1);
				response.sendRedirect("./webSubUser.do?action=getSubUserList");
			} catch (JSONException | KitsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}else if("resendMail".equals(action)){
			
			String phone = request.getParameter("subUser");
			try {
				UserManger.sendVerificaion(phone);
				response.sendRedirect("./webSubUser.do?action=getSubUserList");
			} catch (KitsException e2) {
				e2.printStackTrace();
				response.sendError(500, e2.getMessage());
			}
			
		}else if("deleteSubUser".equals(action)){
			//刪除附屬帳號
			String userphone = (String) session.getAttribute("userphone");
			String subUserUUID = request.getParameter("uuid");
			SubUserManager sum = new SubUserManager((String)session.getAttribute("token"));
			try {
				sum.delSubUser(subUserUUID);
				response.sendRedirect("./webSubUser.do?action=getSubUserList");
			} catch (JSONException | KitsException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
				throw new IOException(e2);
			}
		}else if("usedPoint".equals(action)){
			//導向使用點數頁
			Double userLimitPoint = null;
			Double userCurrentPoint = null;
			Double userInitPoint = null;
			Double userCostPoint = null;
			String token = (String) session.getAttribute("token");
			User usr = new User(token);
			
			
			try {
				usr.updateInfo();
				userLimitPoint = usr.getLimitPoint();
				userCurrentPoint = usr.getCurrentPoint();
				userInitPoint = usr.getInitPoint();
				userCostPoint = usr.getCostPoint();
			} catch (KitsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("userLimitPoint", userLimitPoint);
			request.setAttribute("userCurrentPoint", userCurrentPoint);
			request.setAttribute("userInitPoint", userInitPoint);
			request.setAttribute("userCostPoint", userCostPoint);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/usedPoint.jsp");
			dis.forward(request, response);
		}
		
		
	}

}
