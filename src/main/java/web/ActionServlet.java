package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("uft-8");
		response.setContentType("text/html;charset=utf-8");
		UserDAO dao = new UserDAO();
		
		String url = request.getRequestURI();
		String action = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		
		if ("/list".equals(action)) {
			
		} else if("/add".equals(action)) {
			
		} else if("/del".equals(action)) {
			
		}
	}

}
