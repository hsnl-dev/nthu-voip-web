

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class GetConCallStatusServlet
 */
public class GetConCallStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String sendURL = "http://scb.kits.tw:8080/asyncServlet/subscribe?";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetConCallStatusServlet() {
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
		
		System.out.println("In get con call status sevlet~~");
		
		//¿é¤J°Ñ¼Æ
		String action = request.getParameter("action");
		System.out.println("action = " + action);
				
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		String userphone = (String) session.getAttribute("userphone");
		String concalluuid = (String) session.getAttribute("concalluuid");
		
		if("getConCallMessage".equals(action)){
			boolean isMeetingStop = false;
			if(concalluuid == null){
				isMeetingStop = true;
			}
			while (!isMeetingStop) {
				System.out.println("===in isMeetingStop loop===");
				String par = "uuid=" + concalluuid;
				//connect to server
				URL url = new URL(sendURL + par);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				connection.setRequestMethod("GET");
				connection.connect();
				//connection.setConnectTimeout(150000);
				
				try {
					int code = connection.getResponseCode();
					System.out.println("code = " + code);
					if (code == HttpStatus.SC_OK) {
						/*
						 * Server response exmple
						 * {"action": "update status", "number":"0910609579","status":"meeting"}
						 * where status = calling,meeting,terminate,busy
						 * */
						String status = null;
						String number = null;
						String serverAction = null;
						BufferedReader in = new BufferedReader(
								new InputStreamReader(
										connection.getInputStream()));
						String line = null;
						String jsonStr = null;

						ArrayList jsonList = null;

						while ((line = in.readLine()) != null) {
							System.out.println(line);
							//delay 5 second read response
							/*try {
								Thread.sleep(3000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}*/

							jsonList = (ArrayList) session
									.getAttribute("jsonList");
							if (jsonList == null) {
								jsonList = new ArrayList();
							}

							if (line.startsWith("Server:")) {
								jsonStr = line.substring(7);
							}
							try {
								JSONObject json = new JSONObject(jsonStr);
								serverAction = json.getString("action");
								if("update status".equals(serverAction)){
									number = json.getString("number");
									status = json.getString("status");
									//System.out.println(status + "," + number);
									jsonList.add(json);
									//when host terminate, remove meeting uuid in session, stop read response
									if (userphone.equals(number)
											&& "terminate".equals(status)) {
										session.setAttribute("jsonList", jsonList);
										session.removeAttribute("concalluuid");
										isMeetingStop = true;
										break;
									}
								}else if("end meeting".equals(serverAction)){
									session.setAttribute("jsonList", jsonList);
									session.removeAttribute("concalluuid");
									isMeetingStop = true;
									break;
								}else if("update history".equals(serverAction)){
									session.setAttribute("jsonList", jsonList);
									session.removeAttribute("concalluuid");
									isMeetingStop = true;
									break;
								}
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							session.setAttribute("jsonList", jsonList);
						}
						if (in != null) {
							in.close();
						}
					} else {
						System.out.println("ERROR");
						isMeetingStop = true;
						break;
					}

					if (connection != null) {
						connection.disconnect();
					}
					System.out.println("End of GetConCallStatusServlet!");
				} catch (java.net.SocketTimeoutException e) {
					System.out.println("socket timeout");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					if ("Premature EOF".equals(e.getMessage())) {
						System.out.println(e.getMessage());
					}else if("Connection reset".equals(e.getMessage())){
						System.out.println("handling <==> " + e.getMessage());
						//isMeetingStop = true;
					}else{
						e.printStackTrace();
					}
					if (connection != null) {
						connection.disconnect();
					}
				}
			}
			
		}
	}

}
