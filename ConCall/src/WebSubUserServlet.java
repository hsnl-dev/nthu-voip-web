

import java.io.IOException;
import java.math.BigDecimal;

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
import talk.account.service.xsd.WebAccount;
import talk.bill.service.impl.BillQueryServiceImplService;
import talk.bill.service.impl.BillQueryServiceImplServiceLocator;
import talk.bill.service.impl.BillQueryServiceImplServicePortType;
import talk.billing.service.xsd.Point;

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
		//System.out.println(action);
		
		HttpSession session = request.getSession();
		//session id
		String sid = (String) session.getAttribute("sid");
		
		//建立webservice物件
		BillQueryServiceImplService billService = new BillQueryServiceImplServiceLocator();
		BillQueryServiceImplServicePortType billPort = null;
		
		if("usedPoint".equals(action)){
			//導向使用點數頁
			Point userPoint = null;
			
			try {
				//取得自己point
				billPort = billService.getBillQueryServiceImplServiceHttpSoap11Endpoint();
				userPoint = billPort.queryPointBySession(sid);
			} catch (ServiceException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			//System.out.println("cost point = " + userPoint.getCostPoint());
			//System.out.println("current point = " + userPoint.getCurrentPoint());
			//System.out.println("init point = " + userPoint.getInitPoint());
			//System.out.println("limit point = " + userPoint.getLimitPoint());
			//System.out.println("recom point = " + userPoint.getRecomPoint());
			//System.out.println("charge point = " + userPoint.getChargePoint());
			
			request.setAttribute("userPoint", userPoint);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/usedPoint.jsp");
			dis.forward(request, response);
		}
		
		
	}

}
