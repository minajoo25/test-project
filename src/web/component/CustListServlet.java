package web.component;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cust.Cust;
import com.cust.CustBiz;

@WebServlet({ "/CustListServlet", "/clist" })
public class CustListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustBiz biz;
    public CustListServlet() {
        super();
        biz = new CustBiz();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		ArrayList<Cust> list = null;
		String next = "clist.jsp";
		try {
			list = biz.get();
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		request.setAttribute("cl", list);
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}
}
