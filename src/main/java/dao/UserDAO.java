package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import util.DBUtils;

public class UserDAO {
	/**
	 * 添加用户
	 * @param user
	 */
	public void add(User user) {
		Connection conn = null;
		String sql = "insert into user values(null,?,?,?)";
		try {
			conn = DBUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setInt(2, user.getAge());
			ps.setString(3, user.getPhone());
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}
	/**
	* 删除用户
	* @param user
	*/
	public void del(int id) {
		Connection conn = null;
		String sql = "delete from user where id=?";
		try {
			conn = DBUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
	}
	/**
	 * 查看所有用户
	 * @param user
	 */
	public List<User> find() {
		Connection conn = null;
		String sql = "select * from user";
		List<User> users = new ArrayList<User>();
		try {
			conn = DBUtils.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User u = new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setAge(rs.getInt("age"));
				u.setPhone(rs.getString("phone"));
				users.add(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			DBUtils.closeConnection(conn);
		}
		return users;
	}
}
