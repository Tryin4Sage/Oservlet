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
		//���õ���������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		UserDAO dao = new UserDAO();
		
		//��ȡ�����ַ
		String url = request.getRequestURI();
		String action = url.substring(url.lastIndexOf("/"), url.lastIndexOf("."));
		
		//���ݵ�ַѡ����Ӧ�Ĳ���
		if ("/list".equals(action)) {
			//�����Ӧ���ݼ�
			List<User> users = dao.find();
			//����ת������ת��
			if (users!=null)
			request.setAttribute("users", users);
			request.getRequestDispatcher("List.jsp").forward(request, response);
		} else if("/add".equals(action)) {
			//��ȡ����
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			String phone = request.getParameter("phone");
			
			//�����������û���Ϣ
			User user = new User();
			user.setName(name);
			user.setAge(Integer.parseInt(age));
			user.setName(phone);
			
			//���,���ض���
			dao.add(user);
			response.sendRedirect("list.do");
		} else if("/del".equals(action)) {
			String id = request.getParameter("id");
			
			//ɾ��,���ض���
			dao.del(Integer.parseInt(id));
			response.sendRedirect("list.do");
		} else if("/login".equals(action)) {
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			User user = dao.findByUser(name);
			
			if (user!=null && user.getPhone().equals(phone)) {
				response.sendRedirect("list.do");
			} else {
				request.setAttribute("user_err", "�û������������");
				request.getRequestDispatcher("add.jsp").forward(request, response);
			}
		}
	}

}
