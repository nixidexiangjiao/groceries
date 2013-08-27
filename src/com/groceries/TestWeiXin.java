package com.groceries;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.groceries.pub.SHA1Util;

/**
 * Servlet implementation class TestWeiXin
 */
public class TestWeiXin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(TestWeiXin.class);

	private static String Token = "hyh";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestWeiXin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		
		String[] temp = {Token, timestamp, nonce};
		logger.info("Before sorted, the array is: "
				+ Arrays.toString(temp));
		Arrays.sort(temp);
		logger.info("Before sorted, the array is: "
				+ Arrays.toString(temp));
		
		StringBuffer tempBuf = new StringBuffer();
		for (String s : temp) {
			tempBuf.append(s);
		}
		
		String signature_create = SHA1Util.Encrypt(tempBuf.toString());
		
		if(signature_create.equals(signature)){
			if(!"".equals(echostr) && echostr != null){
				response.getWriter().print(echostr);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Test doPost");
		logger.info("Test doPost");
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		out.println("<html><head><title>Hello World!</title></head>");  
		out.println("<body>");  
		out.println("<h1>Hello World! doPost</h1></body></html>"); 
		out.flush();
	}

}
