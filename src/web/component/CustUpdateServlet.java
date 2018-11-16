package web.component;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.Cust;
import com.cust.CustBiz;

/**
 * Servlet implementation class CustUpdateServlet
 */
@WebServlet({ "/CustUpdateServlet", "/cupdate" })
public class CustUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustBiz biz;
  
    public CustUpdateServlet() {
        super();
        biz = new CustBiz();
    }

	//update view
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//cupdate.jsp
		String id = request.getParameter("id");
		Cust cust = null;
		String next = "cupdate.jsp";
		System.out.println(id);
		try {
			cust = biz.get(id);
			request.setAttribute("uc",cust);
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = 
				request.getRequestDispatcher(next);
		rd.forward(request, response);

	}

	//update implementation
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		Cust cust = new Cust(id,pwd,name,Integer.parseInt(age));
		
		try {
			biz.modify(cust);
			response.sendRedirect("cdetail?id="+id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

}
