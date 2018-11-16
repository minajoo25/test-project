package com.product.test;

import java.util.ArrayList;

import com.product.Product;
import com.product.ProductBiz;

public class SelectAllTest {

	public static void main(String[] args) {
		ProductBiz biz = new ProductBiz();
		ArrayList<Product> list = null;
		try {
			list = biz.get();
			System.out.println("OK");
			for(Product product:list) {
				System.out.println(product);
			}
		}catch(Exception e) {
			System.out.println("FAIL");
			e.printStackTrace();
		}

	}

}
