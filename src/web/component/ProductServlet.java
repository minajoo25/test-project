package web.component;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.product.Product;
import com.product.ProductBiz;


@WebServlet({ "/ProductServlet", "/product" })
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductBiz biz;
   
    public ProductServlet() {
        super();
        biz = new ProductBiz();
    }
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String next = "";
		
		if(cmd.equals("register")){
			MultipartRequest mreq = 
					new MultipartRequest(request, 
							"C:\\jsp\\d03\\web\\img", 
							1024*1024*1024,"EUC-KR");
			String name = mreq.getParameter("name");
			String price = mreq.getParameter("price");
			String imgname = mreq.getOriginalFileName("imgname");
			
			Product p = new Product(name,Integer.parseInt(price),imgname);
			try {
				biz.register(p);
				next ="product/registerok.jsp";
				request.setAttribute("pname", name);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
		}else if(cmd.equals("remove")) {
			String id = request.getParameter("id");
			try {
				biz.remove(Integer.parseInt(id));
				next = "product?cmd=getall";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(cmd.equals("update")) {
			String id = request.getParameter("id");
			Product product = null;
			try {
				product = biz.get(Integer.parseInt(id));
				next = "product/update.jsp";
				request.setAttribute("up", product);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(cmd.equals("updateimpl")) {
			MultipartRequest mreq = 
					new MultipartRequest(request, 
							"C:\\jsp\\d03\\web\\img", 
							1024*1024*1024,"EUC-KR");
			String id = mreq.getOriginalFileName("id");
			String name = mreq.getParameter("name");
			String price = mreq.getParameter("price");
			String imgname = mreq.getOriginalFileName("imgname");
			String newimgname = mreq.getOriginalFileName("newimgname");
			Product p = new Product(Integer.parseInt(id),name,Integer.parseInt(price),imgname);
			/*if(newimgname == null || newimgname.equals("")) {
				p = new Product(Integer.parseInt(id),name,Integer.parseInt(price),imgname);
			}else {
				p = new Product(Integer.parseInt(id),name,Integer.parseInt(price),newimgname);
			}*/
			System.out.println(p.toString());
			try {
				
				biz.modify(p);
				next = "product?cmd=get&id="+id;
				response.sendRedirect(next);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(cmd.equals("get")) {
			String id = request.getParameter("id");
			Product product = null;
			try {
				product = biz.get(Integer.parseInt(id));
				next = "product/detail.jsp";
				request.setAttribute("dp", product);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if(cmd.equals("getall")) {
			ArrayList<Product> list = null;
			try {
				list = biz.get();
				request.setAttribute("plist",list);
				next = "product/list.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
