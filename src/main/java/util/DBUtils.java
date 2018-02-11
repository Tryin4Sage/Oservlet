package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
/**
 * ���ݿ����ӳض����׼��װ;
 * @author Tryin4Sage
 * @date  2018��2��3�� ����11:18:33
 */
public class DBUtils {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	private static int initialSize;
	private static int maxActive;
	private static BasicDataSource bs;
	
	static {
		try {
			//��ȡ�����ļ�����
			Properties cfg = new Properties();
			//�����ȡ�ļ�(��)
			InputStream in = DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
			//������
			cfg.load(in);
			
			// ��ȡ��Ӧ����
			driver = cfg.getProperty("driver");
			url = cfg.getProperty("url");
			user = cfg.getProperty("user");
			password = cfg.getProperty("password");
			initialSize = Integer.parseInt(cfg.getProperty("initialSize"));
			maxActive = Integer.parseInt(cfg.getProperty("maxActive"));
			
			// �������ӳز���
			bs = new BasicDataSource();
			bs.setDriverClassName(driver);
			bs.setUrl(url);
			bs.setUsername(user);
			bs.setPassword(password);
			bs.setInitialSize(initialSize);
			bs.setMaxActive(maxActive);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡ���ݿ����Ӷ���
	 */
	public static Connection getConnection() throws Exception {
		Connection conn = bs.getConnection();
		return conn;
	}
	/**
	 * �黹����
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn!=null) {
				conn.setAutoCommit(true);
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * �ع�
	 * @param conn
	 */
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
