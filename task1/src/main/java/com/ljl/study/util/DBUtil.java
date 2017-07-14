package com.ljl.study.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author alin
 *数据库连接的参数，如数据库名称，账号密码，编码方式等都设计在属性上，便于统一修改，降低维护成本。
 */
public class DBUtil {
	static String ip = "127.0.0.1";
	static int port = 3306;
	static String database = "db_abbey";
	static String encoding = "UTF-8";
	static String loginName = "root";
	static String password = "698970s";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		String url = String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
		return DriverManager.getConnection(url, loginName, password);
	}
	
	public static void main(String[] args) throws SQLException {
		System.out.println(getConnection());
		
	}

	

}
