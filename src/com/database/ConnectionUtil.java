package com.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.utils.StringUtil;

public class ConnectionUtil {
	
	public  static  Connection  createConn(String dbType, String connUrl, String user,String  passwd)
	{
		if (validate(dbType,connUrl,user,passwd)) {
			try {
				Connection  connection = DriverManager.getConnection(connUrl, user, passwd);
				connection.setAutoCommit(false);
				return connection;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return null;
	}
	
	
	public static boolean  validate(String dbType, String connUrl, String user,String  passwd)
	{
		boolean  bRet = false;
		if (StringUtil.isBlank(dbType,connUrl,user,passwd)) {
			System.out.println("database config error:[dbType:" + dbType
											 +"   connUrl:" + connUrl  
											 +"   user:"   +  user
											 +"   passwd:" + passwd);
		} else {
			if ("mysql".equalsIgnoreCase(dbType)) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				bRet = true;
			} else if ("oracle".equalsIgnoreCase(dbType)) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				bRet = true;
			} else if ("sqlserver".equalsIgnoreCase(dbType)) {
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				bRet = true;
			} else {
				System.out.println("unsupport dbType!");
			}
		}
		return bRet ;
	}

}
