package com.product;

import java.sql.Connection;
import java.util.ArrayList;

import com.cust.Cust;
import com.frame.Biz;

public class ProductBiz extends Biz<Integer, Product> {
		ProductDao dao;
			
		public ProductBiz() {
			dao = new ProductDao();
		}
	@Override
	public void register(Product V) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getCon();
		try {
			dao.insert(con, V);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}finally {
			close(con);
		}
		
	}

	@Override
	public void remove(Integer V) throws Exception {
		Connection con = getCon();
		try {
			dao.delete(con,V);
			con.commit();
		}catch(Exception e) {
			con.rollback(); 
			throw e;
		}
		close(con);

	}

	@Override
	public void modify(Product V) throws Exception {
		Connection con = getCon();
		try {
			dao.update(con, V);
			con.commit();
		}catch(Exception e) {
			con.rollback();
			throw e;
		}
		close(con);
	}

	@Override
	public Product get(Integer k) throws Exception {
		Connection con = getCon();
		Product product = null;
		try {
			product = dao.select(con,k);

		}catch(Exception e) {

			throw e;
		}

		return product;
	}

	@Override
	public ArrayList<Product> get() throws Exception {
		Connection con = getCon();
		ArrayList<Product> list = null;
		try {
			list = dao.select(con);
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
		}
		return list;
	}

}
