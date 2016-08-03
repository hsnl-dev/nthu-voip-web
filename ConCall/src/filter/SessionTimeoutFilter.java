package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SessionTimeoutFilter
 */
public class SessionTimeoutFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionTimeoutFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
	    HttpSession session = req.getSession(); 
	    	    
	    String sid = (String) session.getAttribute("sid");
	    //System.out.println("in filter sid = " + sid);
	    //System.out.println(req.getParameter("action"));
	    
	    if(sid != null && !"".equals(sid)){
	    	chain.doFilter(request, response);
	    }else{
	    	String headerName = req.getHeader("x-requested-with");
		    if(headerName != null){
		    	chain.doFilter(request, response);
		    }
		    session.invalidate();
			request.setAttribute("status", "timeout");
			request.setAttribute("option", "forward");
			RequestDispatcher dis = request.getRequestDispatcher("/login.jsp");
			dis.forward(request, response);
	    }
	    
		// pass the request along the filter chain
		//chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
