package util;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 今夜因为一个斜杠找了2个小时
 * <url-pattern>/date1</url-pattern>
 * @author Administrator
 *
 */
public class DateServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		out.println(sdf.format(new Date()));
		
		//String username = request.getParameter("username");
		//String password = request.getParameter("password");
		//String phone = request.getParameter("phone");
		String nickname = request.getParameter("nickname");
		
		out.println("welcome 来到 Tryin4Sage :"+nickname);
		out.close();
	}
	
}
