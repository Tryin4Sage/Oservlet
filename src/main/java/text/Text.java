package text;

import dao.UserDAO;
import entity.User;

public class Text {

	public static void main(String[] args) {
		UserDAO dao = new UserDAO();
		User user = new User();
		
		user.setAge(23);
		user.setName("¶¯Îï");
		user.setPhone("119");
		dao.add(user);
		
		dao.del(6);
		System.out.println(dao.find());
		
	}

}
