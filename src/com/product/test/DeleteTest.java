package com.product.test;

import com.product.ProductBiz;

public class DeleteTest {

	public static void main(String[] args) {	
			ProductBiz biz = new ProductBiz();
			try {
				biz.remove(100);
				System.out.println("OK");
			} catch (Exception e) {
				System.out.println("FAIL");
				e.printStackTrace();
			}

		}

	

}
