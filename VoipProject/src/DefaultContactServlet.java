

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;

import util.Contact;
import util.ContactListComparator;
import util.ContactManager;
import util.KitsException;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class DefaultContactServlet
 */
public class DefaultContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefaultContactServlet() {
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
		
		System.out.println("In DefaultContactSevlet~~");
		
		//輸入參數
		String action = request.getParameter("action");
		
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		
		//for上傳圖片
		String contentType = request.getContentType();
		MultipartRequest multi = null;
		if(contentType != null && contentType.indexOf("multipart/form-data") >= 0){
			String path = getServletContext().getRealPath("/");
			path = path + "img/uploadPicture/";
			//path = path + "img/";
			
			int maxFileSize = 5 * 1024 * 1024 ;
			
			multi = new MultipartRequest(request , path , maxFileSize, "UTF-8");
			action = multi.getParameter("action");
		}
		System.out.println("in post action = " + action);
		
		//建立webservice物件
	
		
		if("insertDefaultContact".equals(action)){
			//新增預設聯絡人的輸入參數
			String cname = multi.getParameter("cname");
			String mobile = multi.getParameter("mobile");
			String office = multi.getParameter("office");
			String imgUrl = multi.getParameter("imgUrl");
			String imgTitle = multi.getParameter("imgTitle");
			String ncode = multi.getParameter("ncode");
			String pcode = multi.getParameter("pcode");
			//System.out.println(cname + "," + mobile + "," + "," + office);
			//System.out.println(imgTitle + "," + imgUrl);
			//System.out.println("ncode," + ncode);
			
			File file = multi.getFile("pic");//取得剛剛上傳的檔案物件  

		    //out.print(file.getAbsolutePath());//秀出檔案總管中的路徑  

		    String photoPath = null;
		    if(file != null){
		    	photoPath = "uploadPicture/" + file.getName();
		    	//photoPath = file.getName();

			    FileInputStream fs = new FileInputStream(file);  

			    byte[] buffer = new byte[fs.available()];  

			    fs.read(buffer,0,buffer.length);  

			    fs.close();
		    }else if(imgUrl != null && !"".equals(imgUrl)){
		    	
		    	Date now = new Date();
		    	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		        String date = DATE_FORMAT.format(now);
		        Calendar cal = Calendar.getInstance();
		    	cal.getTime();
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
		    	String time = sdf.format(cal.getTime());
		        
		        String fileName = (String) session.getAttribute("userphone") + "-" + date + "-" + time;
		    	
		    	//String serverStr = "D://";
		    	String serverStr = "//var//lib//tomcat7//webapps//VoipProject//img//uploadPicture//";
		    	System.out.println(serverStr);
		    	URL url = new URL(imgUrl);
		    	
		    	InputStream in = new BufferedInputStream(url.openStream());
		    	ByteArrayOutputStream out = new ByteArrayOutputStream();
		    	byte[] buf = new byte[1024];
		    	int n = 0;
		    	while (-1!=(n=in.read(buf)))
		    	{
		    	   out.write(buf, 0, n);
		    	}
		    	out.close();
		    	in.close();
		    	byte[] bytearray = out.toByteArray();
		    	
		    	FileOutputStream fos = new FileOutputStream(serverStr + fileName + ".jpg");
		    	fos.write(bytearray);
		    	fos.close();
		
				photoPath = "uploadPicture/" + fileName + ".jpg";
		    }else{
		    	photoPath = "web/default_user.png";
		    }
		    System.out.println(photoPath);
		    
		    //建立contact物件
		    Contact newContact = new Contact();
		    newContact.setName(cname);
		    //檢查國碼
		    if(ncode != null & !"".equals(ncode)){
		    	mobile = ncode+mobile;
		    	newContact.setMobilePhone(mobile);
		    }else{
		    	newContact.setMobilePhone(mobile);
		    }
		    //TAnet前置碼
		    if(pcode != null & !"".equals(pcode)){
		    	if(office != null & !"".equals(office)){
		    		office = pcode + office;
		    	}
		    	newContact.setOfficePhone(office);
		    }else{
		    	newContact.setOfficePhone(office);
		    }
		    newContact.setPic(photoPath);
		    //取得預設聯絡人清單order最大
		
		    
		    ContactManager cm = new ContactManager((String)session.getAttribute("token"));
		    List<Contact> contactList = new ArrayList<Contact>();
		    contactList.add(newContact);
		    try {
				cm.addDefaultContact(contactList);
			} catch (JSONException | KitsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		   //clear user state
		    session.removeAttribute("newuser");

		    request.setAttribute("option", "forward");		
			response.sendRedirect("./default.do?action=editDefault");
		
		}else if("editDefault".equals(action)){
			//管理預設聯絡人清單頁面
			List<Contact> defaultContactListRest = null;
			ContactManager cm = new ContactManager((String)session.getAttribute("token"));
			try {
				//get default contact
				defaultContactListRest = cm.getAllDefalutContact();
				//sort the contact
				Collections.sort(defaultContactListRest,new ContactListComparator());
				request.setAttribute("defaultList", defaultContactListRest);
			    request.setAttribute("option", "forward");		
				RequestDispatcher dis = request.getRequestDispatcher("/defaultList.jsp");
				dis.forward(request, response);
			} catch (JSONException | KitsException e1) {
				e1.printStackTrace();
				response.sendError(500, "Cannot fetch data");
			}
			
			
		}else if("editContact".equals(action)){
			//連到編輯預設聯絡人頁面
			String cname = request.getParameter("cname");
			String uuid = request.getParameter("uuid");
			String mobile = request.getParameter("mobile");
			String office = request.getParameter("office");
			String pic = request.getParameter("pic");
			String contactOrder = request.getParameter("contactOrder");
			
			Contact contact = new Contact();
			contact.setUuid(uuid);
			contact.setName(cname);
			contact.setMobilePhone(mobile);
			contact.setOfficePhone(office);
			contact.setPic(pic);
			contact.setOrder(Integer.parseInt(contactOrder));
			
			session.setAttribute("editDefaultContact", contact);
		    request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/editDefault1.jsp");
			dis.forward(request, response);
		}else if("updateDefaultContact".equals(action)){
			Contact editContact = (Contact) session.getAttribute("editDefaultContact");
			//修改預設聯絡人的輸入參數
			String cname = multi.getParameter("cname");
			String mobile = multi.getParameter("mobile");
			String office = multi.getParameter("office");
			String ncode = multi.getParameter("ncode");
			String pcode = multi.getParameter("pcode");
			//System.out.println(cname + "," + mobile + "," + "," + office);
			//System.out.println("ncode," + ncode);
			
			File file = multi.getFile("pic");//取得剛剛上傳的檔案物件  

		    //out.print(file.getAbsolutePath());//秀出檔案總管中的路徑  

		    String photoPath = null;
		    if(file != null){
		    	photoPath = "uploadPicture/" + file.getName();
		    	//photoPath = file.getName();

			    FileInputStream fs = new FileInputStream(file);  

			    byte[] buffer = new byte[fs.available()];  

			    fs.read(buffer,0,buffer.length);  

			    fs.close();
		    }else{
		    	photoPath = editContact.getPic();
		    }
		    System.out.println(photoPath);
		    
		    //建立contact物件
		    Contact newContact = new Contact();
		    newContact.setUuid(editContact.getUuid());
		    newContact.setName(cname);
		    //檢查國碼
		    if(ncode != null & !"".equals(ncode)){
		    	mobile = ncode+mobile;
		    	newContact.setMobilePhone(mobile);
		    }else{
		    	newContact.setMobilePhone(mobile);
		    }
		    if(pcode != null & !"".equals(pcode)){
		    	if(office != null & !"".equals(office)){
		    		office = pcode + office;
		    	}
		    	newContact.setOfficePhone(office);
		    }else{
		    	newContact.setOfficePhone(office);
		    }
		    newContact.setPic(photoPath);
		    newContact.setOrder(editContact.getOrder());
		   
		    ContactManager cm = new ContactManager((String)session.getAttribute("token"));
		    try {
				cm.updateDefalutContact(newContact);
				response.sendRedirect("./default.do?action=editDefault");
			} catch (JSONException | KitsException e1) {
				response.sendError(500, "Error");
				e1.printStackTrace();
			}
		    
		   
		}else if("saveDefaultContactOrder".equals(action)){
			//修改預設聯絡人排序
			String orderStr = request.getParameter("order");
			String uuidStr = request.getParameter("uuidAry");
			String[] orderAry = orderStr.split(",");
			String[] uuidAry = uuidStr.split(",");
			
			/*TODO get the api to fix it*/
			response.sendRedirect("./default.do?action=editDefault");
		}else if("deleteDefaultContact".equals(action)){
			//刪除預設聯絡人
			Contact editContact = (Contact) session.getAttribute("editDefaultContact");
		
			
		    ContactManager cm = new ContactManager((String)session.getAttribute("token"));
		    try {
				cm.delDefalutContact(editContact.getUuid());
			} catch (JSONException | KitsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    response.sendRedirect("./default.do?action=editDefault");
		}
	}

}
