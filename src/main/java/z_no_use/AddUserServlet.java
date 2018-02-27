package z_no_use;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;

public class AddUserServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setAge(age);
		user.setName(name);
		user.setPhone(phone);
		try {
			dao.add(user);
			response.sendRedirect("list");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
