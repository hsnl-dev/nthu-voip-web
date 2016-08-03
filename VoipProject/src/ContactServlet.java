

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
import java.util.Arrays;
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


import util.Call;
import util.Contact;
import util.ContactListComparator;
import util.ContactManager;
import util.KitsException;
import util.User;

import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class ContactServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
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
		
		System.out.println("In ContactSevlet~~");
		
		//輸入參數
		String action = request.getParameter("action");
		System.out.println("action = " + action);
				
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		//String bigOrder = (String) session.getAttribute("bigOrder");
		
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
		
		
		String resStr = null;
		
		if("insertNewContact".equals(action)){
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
			//System.out.println("pcode," + pcode);
			
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
		    	//google search
		    	Date now = new Date();
		    	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		        String date = DATE_FORMAT.format(now);
		        Calendar cal = Calendar.getInstance();
		    	cal.getTime();
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
		    	String time = sdf.format(cal.getTime());
		    	
		        String fileName = (String) session.getAttribute("userphone") + "-" + date + "-" + time;
		        
		    	//String serverStr = "D://";
		    	String serverStr = "//var//lib//tomcat6//webapps//VoipProject//img//uploadPicture//";
		    	//System.out.println(serverStr);
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
		    // refactoring
		    Contact newContactRest = new Contact();
		    newContactRest.setName(cname);
		    //檢查國碼
		    if(ncode != null & !"".equals(ncode)){
		    	mobile = ncode+mobile;
		    	newContactRest.setMobilePhone(mobile);
		    }else{
		    	newContactRest.setMobilePhone(mobile);
		    }
		    //TAnet前置碼
		    if(pcode != null & !"".equals(pcode)){
		    	if(office != null & !"".equals(office)){
		    		office = pcode + office;
		    	}
		    	newContactRest.setOfficePhone(office);
		    }else{
		    	newContactRest.setOfficePhone(office);
		    }
		    newContactRest.setPic(photoPath);

		    ArrayList<Contact> usrContactListRest = new ArrayList<Contact>();
		    usrContactListRest.add(newContactRest);
		    ContactManager cm = new ContactManager((String)session.getAttribute("token"));
		    try {
				cm.addContact(usrContactListRest);
			} catch (JSONException | KitsException e1) {
				e1.printStackTrace();
			}
		    response.sendRedirect("./contact.do?action=editMode");
			
			
		}else if("editMode".equals(action)){
			//連到編輯聯絡人頁面
			
			ContactManager cm = new ContactManager((String)session.getAttribute("token"));
			List<Contact> contactListRest =null;
			List<Contact> defaultContactListRest =null;
			List<Contact> allContactListRest =null;
			
			try {
				//get contact info 
				contactListRest = cm.getAllContact();
				defaultContactListRest = cm.getAllDefalutContact();
				
				//create contact list
				allContactListRest = new ArrayList<Contact>(contactListRest);
				allContactListRest.addAll(defaultContactListRest);
				
				//sort
				Collections.sort(allContactListRest,new ContactListComparator());
			} catch (JSONException | KitsException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("contactList", contactListRest);
			request.setAttribute("defaultContactList", defaultContactListRest);
			request.setAttribute("allContactList", allContactListRest);
		
		    request.setAttribute("option", "forward");		
		
			RequestDispatcher dis = request.getRequestDispatcher("/editMode1.jsp");
			dis.forward(request, response);
		}else if("editContact".equals(action)){
			//連到編輯聯絡人頁面
			String cname = request.getParameter("cname");
			String mobile = request.getParameter("mobile");
			String office = request.getParameter("office");
			String uuid = request.getParameter("uuid");
			String pic = request.getParameter("pic");
			String contactOrder = request.getParameter("contactOrder");
			
			Contact contact = new Contact();
			contact.setUuid(uuid);
			contact.setName(cname);
			contact.setMobilePhone(mobile);
			contact.setOfficePhone(office);
			contact.setPic(pic);
			contact.setOrder(Integer.parseInt(contactOrder));
			
			session.setAttribute("editContact", contact);
		    request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/editContact1.jsp");
			dis.forward(request, response);
		}else if("updateContact".equals(action)){
			//修改聯絡人
			Contact editContact = (Contact) session.getAttribute("editContact");
			//修改的參數
			String cname = multi.getParameter("cname");
			String mobile = multi.getParameter("mobile");
			String office = multi.getParameter("office");
			String ncode = multi.getParameter("ncode");
			String pcode = multi.getParameter("pcode");
			//System.out.println(cname + "," + mobile + "," + "," + office);
			//System.out.println("ncode = " + ncode);
			
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
		    	mobile = ncode + mobile;
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
				cm.updateContact(newContact);
			} catch (JSONException | KitsException e1) {
				e1.printStackTrace();
			}
		    response.sendRedirect("./contact.do?action=editMode");
		    
		}else if("call".equals(action)){
			//撥電話
			String number = request.getParameter("number");
			if(number.startsWith(" ")){
				//國際
				number = "+" + number.substring(1);
				System.out.println("call action number = " + number);
			}else{
				System.out.println("call action number = " + number);
			}
			Call call = new Call((String)session.getAttribute("token"));
			User user = new User((String)session.getAttribute("token"));
			try {
				user.updateInfo();
				call.initCall(number, user.getCardId());
			} catch (KitsException e) {
				e.printStackTrace();
			}
			
			
			
		}else if("saveContactOrder".equals(action)){
			
			//儲存聯絡人排序
			String orderStr = request.getParameter("order");
			String uuidStr = request.getParameter("uuidAry");
			//System.out.println(orderStr);
			//System.out.println(uuidStr);
			
			String[] orderAry = orderStr.split(",");
			String[] uuidAry = uuidStr.split(",");
			ContactManager cm = new ContactManager((String)session.getAttribute("token"));
			try {
				cm.updateContactOrder(Arrays.asList(uuidAry));
			} catch (JSONException | KitsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			response.sendRedirect("./contact.do?action=editMode");
		}else if("deleteContact".equals(action)){
			
			//刪除聯絡人
			Contact editContact = (Contact) session.getAttribute("editContact");
			String deleteOneContact = editContact.getUuid();
			String[] deleteContact = {editContact.getUuid()};
			ContactManager cm = new ContactManager((String) session.getAttribute("token"));
			try {
				cm.delContact(deleteOneContact);
				response.sendRedirect("./contact.do?action=editMode");
			} catch (JSONException | KitsException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				response.sendError(500);
			}
			
		}else{ //顯示聯絡人清單可以撥號
			
			
			ContactManager cm = new ContactManager((String)session.getAttribute("token"));
			List<Contact> contactListRest =null;
			List<Contact> defaultContactListRest =null;
			List<Contact> allContactListRest =null;
			
			try {
				//get contact info 
				contactListRest = cm.getAllContact();
				defaultContactListRest = cm.getAllDefalutContact();
				
				//create contact list
				allContactListRest = new ArrayList<Contact>(contactListRest);
				allContactListRest.addAll(defaultContactListRest);
				
				//sort the contact
				Collections.sort(allContactListRest,new ContactListComparator());
			
				
			} catch (JSONException | KitsException e1) {
				e1.printStackTrace();
			}
			
		    //取最新10筆紀錄
		   /* ArrayList history = null;
		    if(historyList != null){
		    	history = new ArrayList();
		    	for(int i = 0; i < 10; i++){
		    		String[] record = new String[2];
		    		if(historyList.length-1-i >=0){
		    			String num = historyList[historyList.length-1-i].getNumber();
		    			for(int j = 0; j < allContactList.size(); j++){
		    				WebContact temp = (WebContact) allContactList.get(j);
		    				if(num.equals(temp.getOfficePhone())){
		    					record[0] = temp.getName();
		    					record[1] = num;
		    					history.add(record);
		    					break;
		    				}else if(num.equals(temp.getMobilePhone())){
		    					record[0] = temp.getName();
		    					record[1] = num;
		    					history.add(record);
		    					break;
		    				}
		    			}
		    		}
		    	}
		    }*/
		    
		   
			request.setAttribute("contactList", contactListRest);
			request.setAttribute("defaultContactList", defaultContactListRest);
			request.setAttribute("allContactList", allContactListRest);
			//request.setAttribute("historyList", history);
		    request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/contactList1.jsp");
			dis.forward(request, response);
		}
		
	}

}
