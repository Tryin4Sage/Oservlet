package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class ListUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		UserDAO dao = new UserDAO();
		List<User> users = dao.find();
		for (User user : users) {
			out.println(user.getId());
			out.println(user.getName());
			out.println(user.getAge());
			out.println(user.getPhone());
			out.println("<p><a href='del?id="+user.getId()+"'>delete</a><p>");
			out.println("<br>");
		}
		out.println("<p><a href='add.html'>ÃÌº””√ªß</a><p>");
	}
}
