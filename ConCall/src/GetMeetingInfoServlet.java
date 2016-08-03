

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class GetMeetingInfoServlet
 */
public class GetMeetingInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMeetingInfoServlet() {
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
		
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		
		//System.out.println("In get meeting info servlet~~");
		
		//¿é¤J°Ñ¼Æ
		String action = request.getParameter("action");
		//System.out.println(timeStamp + " action = " + action);
		
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		
		if("getMeetingInfo".equals(action)){
			String userphone = (String) session.getAttribute("userphone");
			ArrayList jsonList = (ArrayList) session.getAttribute("jsonList");
			String index = (String) session.getAttribute("jsonListIndex");
			if(index == null){
				index = "0";
			}
			String number = null;
			String status = null;
			String returnStr = "";
			if(jsonList != null && jsonList.size() > 0){
				//System.out.println("json list index = " + index + ", size = " + jsonList.size());
				for(int i = Integer.parseInt(index); i < jsonList.size(); i++){
					JSONObject json = (JSONObject) jsonList.get(i);
					try {
						number = json.getString("number");
						status = json.getString("status");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					returnStr += number + ":" + status + ",";
				}
				if(!"".equals(returnStr)){
					returnStr = returnStr.substring(0, returnStr.length()-1);
				}
				System.out.println(timeStamp + ", returnStr = " + returnStr);
				index = String.valueOf(jsonList.size());
				session.setAttribute("jsonListIndex",index);
				
				if(userphone.equals(number) && "terminate".equals(status)){
					System.out.println("host terminate clear session!");
					session.removeAttribute("jsonList");
					session.removeAttribute("jsonListIndex");
				}
				String uuid = (String) session.getAttribute("concalluuid");
				if(uuid == null){
					returnStr = "meeting close";
					System.out.println("concall uuid is null clear session!");
					session.removeAttribute("jsonList");
					session.removeAttribute("jsonListIndex");
				}
			}
			
			response.setContentType("text/plain");  
		    response.setCharacterEncoding("UTF-8"); 
		    response.getWriter().write(returnStr);
		}
	}

}
