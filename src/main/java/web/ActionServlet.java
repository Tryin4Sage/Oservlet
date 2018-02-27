package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import entity.User;
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		//常用的设置属性
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserDAO dao = new UserDAO();
		
		//获取请求地址
		String url = request.getRequestURI();
		String action = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		
		//根据地址选择相应的操作
		if ("/list".equals(action)) {
			//获得响应数据集
			List<User> users = dao.find();
			//设置转发器并转发
			if (users!=null)
			request.setAttribute("users", users);
			request.getRequestDispatcher("List.jsp").forward(request, response);
		} else if("/add".equals(action)) {
			//获取参数
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String phone = request.getParameter("phone");
			
			//创建并设置用户信息
			User user = new User();
			user.setName(name);
			user.setAge(Integer.parseInt(age));
			user.setName(phone);
			
			//添加,并重定向
			dao.add(user);
			response.sendRedirect("list.do");
		} else if("/del".equals(action)) {
			String id = request.getParameter("id");
			
			//删除,并重定向
			dao.del(Integer.parseInt(id));
			response.sendRedirect("list.do");
		} else if("/login".equals(action)) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			User user = dao.findByUser(name);
			
			if (user!=null && user.getPhone().equals(phone)) {
				response.sendRedirect("list.do");
			} else {
				request.setAttribute("user_err", "用户名或密码错误");
				request.getRequestDispatcher("add.jsp").forward(request, response);
			}
		}
	}

}
