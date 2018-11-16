package com.frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Biz<K,V> {
	String workspace = "db";
	String password = "db";
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	
	public Biz() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public Connection getCon() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, workspace, password);
			con.setAutoCommit(false); //commit 해야 db에 반응한다.commit, rollback가능
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public void close (Connection con) {
		if(con != null);
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	public abstract void register(V V) throws Exception;
	public abstract void remove(K V) throws Exception;
	public abstract void modify(V V) throws Exception;
	public abstract V get(K k) throws Exception;
	public abstract ArrayList<V> get() throws Exception;
}	
