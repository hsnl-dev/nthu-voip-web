

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
import talk.account.service.xsd.WebContact;
import talk.concall.calling.service.impl.ConCallCallingServiceImpl;
import talk.concall.calling.service.impl.ConCallCallingServiceImplLocator;
import talk.concall.calling.service.impl.ConCallCallingServiceImplPortType;
import util.MyComparator;

/**
 * Servlet implementation class HistoryServlet
 */
public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoryServlet() {
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
		
		System.out.println("In HistorySevlet~~");
		
		//輸入參數
		String action = request.getParameter("action");
		System.out.println("action = " + action);
				
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		
		//建立webservice物件
		AccountContactServiceImplService contactService = new AccountContactServiceImplServiceLocator();
		AccountContactServiceImplServicePortType contactPort = null;
		ConCallCallingServiceImpl concallService = new ConCallCallingServiceImplLocator();
		ConCallCallingServiceImplPortType concallPort = null;
		String resStr = null;
		
		if("getHistory".equals(action)){
			System.out.println(" in HistoryServlet get history action");
			
			WebContact[] contactList = null;
			String status = null;
			JSONArray uuidList = null;
			JSONArray infoList = null;
			String meetinguuid = null;
			
			try {
				contactPort = contactService.getAccountContactServiceImplServiceHttpSoap11Endpoint();
				contactList = contactPort.getWebContactList(sid);
				
				concallPort = concallService.getConCallCallingServiceImplHttpSoap11Endpoint();
				resStr = concallPort.getHistoryList(sid);
				System.out.println("in historyServlet get history response string = " + resStr);
				
				JSONObject json = new JSONObject(resStr);
				status = json.getString("status");
				if("SUCCESS".equals(status)){
					uuidList = json.getJSONArray("uuidList");
					//System.out.println(uuidList.length());
					String[] UUIDList = new String[uuidList.length()];
					for(int i = 0; i < uuidList.length(); i++){
						JSONObject obj = (JSONObject) uuidList.get(i);
						meetinguuid = obj.getString("uuid");
						//System.out.println(meetinguuid);
						
						UUIDList[i] = meetinguuid;
					}
					resStr = concallPort.getMeetingInfo(sid, UUIDList);
					System.out.println("in historyServlet get meeting info response string = " + resStr);
					JSONObject infojson = new JSONObject(resStr);
					status = infojson.getString("status");
					if("SUCCESS".equals(status)){
						infoList = infojson.getJSONArray("infoList");
					}
				}
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("status", status);
			request.setAttribute("infoList", infoList);
			request.setAttribute("contactList", contactList);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/history.jsp");
			dis.forward(request, response);
		}else if("startMeeting".equals(action)){
			String numberStr = request.getParameter("numberStr");
			String pastListStr = request.getParameter("pastListStr");
			String imgStr = request.getParameter("imgStr");
			System.out.println(" in HistoryServlet start meeting action number string = " + numberStr);
			System.out.println(" in HistoryServlet start meeting action img src string = " + imgStr);
			
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
			request.setAttribute("numberStr", numberStr);
			request.setAttribute("pastListStr", pastListStr);
			request.setAttribute("imgStr", imgStr);
			request.setAttribute("status", "startMeetingByHistory");
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/contactList1.jsp");
			dis.forward(request, response);
		}
	}

}
