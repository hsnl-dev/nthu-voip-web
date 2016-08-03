

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import org.json.JSONException;
import org.json.JSONObject;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import com.oreilly.servlet.MultipartRequest;

import talk.account.service.impl.AccountContactServiceImplService;
import talk.account.service.impl.AccountContactServiceImplServiceLocator;
import talk.account.service.impl.AccountContactServiceImplServicePortType;
import talk.account.service.xsd.WebContact;
import talk.calling.service.impl.CallingServiceImplService;
import talk.calling.service.impl.CallingServiceImplServiceLocator;
import talk.calling.service.impl.CallingServiceImplServicePortType;
import talk.concall.calling.service.impl.ConCallCallingServiceImpl;
import talk.concall.calling.service.impl.ConCallCallingServiceImplLocator;
import talk.concall.calling.service.impl.ConCallCallingServiceImplPortType;
import util.ImageResize;
import util.MyComparator;

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
		
		String timeStamp = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
		
		System.out.println("In ContactSevlet~~");
		
		//輸入參數
		String action = request.getParameter("action");
		System.out.println(timeStamp + " action = " + action);
				
		HttpSession session = request.getSession();
		String sid = (String) session.getAttribute("sid");
		//String bigOrder = (String) session.getAttribute("bigOrder");
		
		//for上傳圖片
		String contentType = request.getContentType();
		/*
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
	    // maximum size that will be stored in memory
	    factory.setSizeThreshold(maxMemSize);
	    // Location to save data that is larger than maxMemSize.
	    factory.setRepository(new File("c:\\temp"));
	    // Create a new file upload handler
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    // maximum file size to be uploaded.
	    upload.setSizeMax( maxFileSize );
		*/
		
		MultipartRequest multi = null;
		if(contentType != null && contentType.indexOf("multipart/form-data") >= 0){
			String path = getServletContext().getRealPath("/");
			path = path + "img/uploadPicture/";
			//path = path + "img/";
			
			int maxFileSize = 5 * 1024 * 1024 ;
			
			multi = new MultipartRequest(request , path , maxFileSize, "UTF-8");
			action = multi.getParameter("action");
		}
		
		//建立webservice物件
		AccountContactServiceImplService contactService = new AccountContactServiceImplServiceLocator();
		AccountContactServiceImplServicePortType contactPort = null;
		CallingServiceImplService callService = new CallingServiceImplServiceLocator();
		CallingServiceImplServicePortType callPort = null;
		ConCallCallingServiceImpl concallService = new ConCallCallingServiceImplLocator();
		ConCallCallingServiceImplPortType concallPort = null;
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
		    	
		    	//新的檔名
		    	Date now = new Date();
		    	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		        String date = DATE_FORMAT.format(now);
		        Calendar cal = Calendar.getInstance();
		    	cal.getTime();
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
		    	String time = sdf.format(cal.getTime());
		    	
		        String fileName = (String) session.getAttribute("userphone") + "-" + date + "-" + time;
		        //取得副檔名
		        int startIndex = file.getName().lastIndexOf(46) + 1;
		        int endIndex = file.getName().length();
		        System.out.println("副檔名 = " + file.getName().substring(startIndex, endIndex));
		        fileName += "." + file.getName().substring(startIndex, endIndex);

		        int orientation = 1;
		        try {
		        	//read EXIF data
					Metadata metadata = ImageMetadataReader.readMetadata(file);
					/*for (Directory directory : metadata.getDirectories()) {
					    for (Tag tag : directory.getTags()) {
					        System.out.println(tag);
					    }
					}*/
					// obtain the Exif directory
					ExifIFD0Directory directory = metadata.getDirectory(ExifIFD0Directory.class);

					// query the tag's value
					orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
					System.out.println("orientation = " + orientation);
				} catch (ImageProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MetadataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        try {
		        	//rename
					String directorypath = getServletContext().getRealPath("/");
					directorypath = directorypath + "img/uploadPicture/";
					File newName = new File(directorypath + fileName);
					boolean issuccess = file.renameTo(newName);
					System.out.println("rename = " + issuccess);
			    	
			    	//resize image
			    	BufferedImage originalImage = ImageIO.read(newName);
			    	int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			    	//System.out.println(originalImage.getWidth() + "*" + originalImage.getHeight());
					BufferedImage resizeImageHintPng = ImageResize.resizeImageWithHint(originalImage, type, originalImage.getWidth(), originalImage.getHeight());
					File finalName = new File(directorypath + "u" + fileName);
					switch(orientation){
						case 1:
							ImageIO.write(resizeImageHintPng, "png", finalName);
							break;
						case 3:
							resizeImageHintPng = ImageResize.rotate180(resizeImageHintPng);
							ImageIO.write(resizeImageHintPng, "png", finalName);
							break;
						case 6:
							resizeImageHintPng = ImageResize.rotate90ToRight(resizeImageHintPng);
							ImageIO.write(resizeImageHintPng, "png", finalName);
							break;
						default:
							ImageIO.write(resizeImageHintPng, "png", finalName);
							break;
					}
					newName.delete();
					photoPath = "uploadPicture/u" + fileName;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		    	String serverStr = "//var//lib//tomcat6//webapps//ConCall//img//uploadPicture//";
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
		    
		    //建立contact物件
		    WebContact newContact = new WebContact();
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
		    WebContact[] usrContactList = {newContact};
		    WebContact[] contactList = null;
			
		    try {
		    	//新增聯絡人
		    	contactPort = contactService.getAccountContactServiceImplServiceHttpSoap11Endpoint();
		    	resStr = contactPort.addWebContactList(sid, usrContactList);
		    	System.out.println("in add web contact list response string = " + resStr);
		    	
		    	contactList = contactPort.getWebContactList(sid);
		    	/*
		    	for(int i = 0; i < contactList.length; i++){
		    		System.out.println(contactList[i].getName() + "," + contactList[i].getOrder());
		    	}
		    	*/		    	
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    if(contactList != null){
				Arrays.sort(contactList, new MyComparator());
			}
		    
			request.setAttribute("contactList", contactList);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/editMode1.jsp");
			dis.forward(request, response);
			
		}else if("editMode".equals(action)){
			//連到編輯聯絡人頁面
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
			
			WebContact contact = new WebContact();
			contact.setUUID(uuid);
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
			WebContact editContact = (WebContact) session.getAttribute("editContact");
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
		    	
		    	//新的檔名
		    	Date now = new Date();
		    	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
		        String date = DATE_FORMAT.format(now);
		        Calendar cal = Calendar.getInstance();
		    	cal.getTime();
		    	SimpleDateFormat sdf = new SimpleDateFormat("HH-mm-ss");
		    	String time = sdf.format(cal.getTime());
		    	
		        String fileName = (String) session.getAttribute("userphone") + "-" + date + "-" + time;
		        //取得副檔名
		        int startIndex = file.getName().lastIndexOf(46) + 1;
		        int endIndex = file.getName().length();
		        System.out.println("副檔名 = " + file.getName().substring(startIndex, endIndex));
		        fileName += "." + file.getName().substring(startIndex, endIndex);
		        
		        int orientation = 1;
		        try {
		        	//read EXIF data
					Metadata metadata = ImageMetadataReader.readMetadata(file);
					/*for (Directory directory : metadata.getDirectories()) {
					    for (Tag tag : directory.getTags()) {
					        System.out.println(tag);
					    }
					}*/
					// obtain the Exif directory
					ExifIFD0Directory directory = metadata.getDirectory(ExifIFD0Directory.class);

					// query the tag's value
					orientation = directory.getInt(ExifIFD0Directory.TAG_ORIENTATION);
					//System.out.println("orientation = " + orientation);
				} catch (ImageProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MetadataException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		        try {
		        	//rename
					String directorypath = getServletContext().getRealPath("/");
					directorypath = directorypath + "img/uploadPicture/";
					File newName = new File(directorypath + fileName);
					boolean issuccess = file.renameTo(newName);
					System.out.println("rename = " + issuccess);
			    	
			    	//resize image
			    	BufferedImage originalImage = ImageIO.read(newName);
			    	int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
			    	//System.out.println(originalImage.getWidth() + "*" + originalImage.getHeight());
					BufferedImage resizeImageHintPng = ImageResize.resizeImageWithHint(originalImage, type, originalImage.getWidth(), originalImage.getHeight());
					File finalName = new File(directorypath + "u" + fileName);
					switch(orientation){
						case 1:
							ImageIO.write(resizeImageHintPng, "png", finalName);
							break;
						case 3:
							resizeImageHintPng = ImageResize.rotate180(resizeImageHintPng);
							ImageIO.write(resizeImageHintPng, "png", finalName);
							break;
						case 6:
							resizeImageHintPng = ImageResize.rotate90ToRight(resizeImageHintPng);
							ImageIO.write(resizeImageHintPng, "png", finalName);
							break;
						default:
							ImageIO.write(resizeImageHintPng, "png", finalName);
							break;
					}
					newName.delete();
					photoPath = "uploadPicture/u" + fileName;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }else{
		    	photoPath = editContact.getPic();
		    }
		    System.out.println(photoPath);
		    
		    //建立contact物件
		    WebContact newContact = new WebContact();
		    newContact.setUUID(editContact.getUUID());
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
			WebContact[] contactList = null;
			
		    try {
		    	//修改聯絡人
		    	contactPort = contactService.getAccountContactServiceImplServiceHttpSoap11Endpoint();
		    	resStr = contactPort.setWebContact(sid, newContact);
		    	System.out.println("in edit web contact list response string = " + resStr);
		    	contactList = contactPort.getWebContactList(sid);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    session.removeAttribute("editContact");
		    if(contactList != null){
				Arrays.sort(contactList, new MyComparator());
			}
		    
			request.setAttribute("contactList", contactList);
		    request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/contactList1.jsp");
			dis.forward(request, response);
		}else if("call".equals(action)){
			//撥電話
			String uuid = (String) session.getAttribute("concalluuid");
			String number = request.getParameter("number");
			String userphone = (String) session.getAttribute("userphone");
			System.out.println("con call uuid = " + uuid);
			//System.out.println("call action userphone = " + userphone);
			if(number.startsWith(" ")){
				//國際
				number = "+" + number.substring(1);
				System.out.println("call action number = " + number);
			}else{
				System.out.println("call action number = " + number);
			}
			
			if(uuid != null){
				//邀請新成員到會議中
				System.out.println(number + "," + uuid);
				String[] numberAry = {number};
				try {
					concallPort = concallService.getConCallCallingServiceImplHttpSoap11Endpoint();
					resStr = concallPort.webInviteMember(sid, uuid, numberAry);
					System.out.println("invite Member action response String = " + resStr);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				//System.out.println("start meeting");
				String[] numberAry = {userphone,number};
				try {
					//舊版
					//callPort = callService.getCallingServiceImplServiceHttpSoap11Endpoint();
					//resStr = callPort.startCallingByWeb(sid, number);
					//新版concall api
					concallPort = concallService.getConCallCallingServiceImplHttpSoap11Endpoint();
					resStr = concallPort.webStartMeeting(sid, numberAry);
					System.out.println("call action response String = " + resStr);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					//System.out.println("exception");
					e.printStackTrace();
				}
				//for con call
				String status = null;
				uuid = null;
				try {
					JSONObject json = new JSONObject(resStr);
					status = json.getString("status");
					System.out.println(status);
					if("SUCCESS".equals(status)){
						uuid = json.getString("uuid");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(uuid != null){
					System.out.println("concall uuid = " + uuid);
					session.setAttribute("concalluuid", uuid);
				}
				response.setContentType("text/plain");  
			    response.setCharacterEncoding("UTF-8"); 
			    response.getWriter().write(uuid);
			}
		}else if("callByHistory".equals(action)){
			String uuid = (String) session.getAttribute("concalluuid");
			String numberStr = request.getParameter("number");
			String userphone = (String) session.getAttribute("userphone");;
			System.out.println("number string = " + numberStr);
			
			if(uuid != null){
				
			}else{
				String[] tmp = numberStr.split(",");
				String[] numberAry = new String[tmp.length+1];
				for(int i = 0; i < numberAry.length; i++){
					if(i == 0){
						numberAry[i] = userphone;
					}else{
						numberAry[i] = tmp[i-1];
					}
				}
				try {
					concallPort = concallService.getConCallCallingServiceImplHttpSoap11Endpoint();
					resStr = concallPort.webStartMeeting(sid, numberAry);
					System.out.println("call action response String = " + resStr);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					//System.out.println("exception");
					e.printStackTrace();
				}
				String status = null;
				uuid = null;
				try {
					JSONObject json = new JSONObject(resStr);
					status = json.getString("status");
					System.out.println(status);
					if("SUCCESS".equals(status)){
						uuid = json.getString("uuid");
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(uuid != null){
				System.out.println("concall uuid = " + uuid);
				session.setAttribute("concalluuid", uuid);
			}
			
			response.setContentType("text/plain");  
		    response.setCharacterEncoding("UTF-8"); 
		    response.getWriter().write(uuid);
		}else if("inviteMemberToMeeting".equals(action)){
			//邀請新成員到會議中
			String number = request.getParameter("number");
			String uuid = (String) session.getAttribute("concalluuid");
			System.out.println(number + "," + uuid);
			String[] numberAry = {number};
			try {
				concallPort = concallService.getConCallCallingServiceImplHttpSoap11Endpoint();
				resStr = concallPort.webInviteMember(sid, uuid, numberAry);
				System.out.println("invite Member action response String = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if("kickMemberToMeeting".equals(action)){
			//移除新成員到會議中
			String number = request.getParameter("number");
			String uuid = (String) session.getAttribute("concalluuid");
			if(number.length() == 9 && number.startsWith("9")){
				number = "0" + number;
			}
			System.out.println(number + "," + uuid);
			String[] numberAry = {number};
			try {
				concallPort = concallService.getConCallCallingServiceImplHttpSoap11Endpoint();
				resStr = concallPort.webKickMember(sid, uuid, numberAry);
				System.out.println("kick Member action response String = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else if("meetingTerminate".equals(action)){
			String conuuid = request.getParameter("conuuid");
			String uuid = (String) session.getAttribute("concalluuid");
			System.out.println(uuid + "," + conuuid);
			
			try {
				concallPort = concallService.getConCallCallingServiceImplHttpSoap11Endpoint();
				resStr = concallPort.forceTerminate(uuid);
				System.out.println("meeting terminate action response String = " + resStr);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
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
			
			System.out.println("in save order");
			for(int i = 0; i < orderAry.length; i++){
				System.out.println(orderAry[i]);
			}
			for(int i = 0; i < uuidAry.length; i++){
				System.out.println(uuidAry[i]);
			}
			System.out.println("end of save order");
			
			WebContact[] contactList = null;
			
			try {
				contactPort = contactService.getAccountContactServiceImplServiceHttpSoap11Endpoint();
				resStr = contactPort.setWebContactOrder(sid, uuidAry);
				System.out.println("in save contact order response string = " + resStr);
				
				contactList = contactPort.getWebContactList(sid);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
			request.setAttribute("contactList", contactList);
		    request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/editMode1.jsp");
			dis.forward(request, response);
		}else if("deleteContact".equals(action)){
			//刪除聯絡人
			WebContact editContact = (WebContact) session.getAttribute("editContact");
			String[] deleteContact = {editContact.getUUID()};
			WebContact[] contactList = null;
						
			try {
				contactPort = contactService.getAccountContactServiceImplServiceHttpSoap11Endpoint();
				resStr = contactPort.delWebContactList(sid, deleteContact);
				System.out.println("in delete contact list responce string = " + resStr);
				
				contactList = contactPort.getWebContactList(sid);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.removeAttribute("editContact");
			if(contactList != null){
				Arrays.sort(contactList, new MyComparator());
			}
			
		    request.setAttribute("contactList", contactList);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/editMode1.jsp");
			dis.forward(request, response);
		}else{ //顯示聯絡人清單可以撥號
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
			/*
			for(int i = 0; i < contactList.length; i++){
				System.out.println(contactList[i].getUUID() + ", order=" + contactList[i].getOrder());
			}
			*/
			
		    request.setAttribute("contactList", contactList);
			request.setAttribute("option", "forward");		
			RequestDispatcher dis = request.getRequestDispatcher("/contactList1.jsp");
			dis.forward(request, response);
		}
		
	}

}
