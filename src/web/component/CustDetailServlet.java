package web.component;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.Cust;
import com.cust.CustBiz;


@WebServlet({ "/CustDetailServlet", "/cdetail" })
public class CustDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustBiz biz;
   
    public CustDetailServlet() {
        super();
        biz = new CustBiz();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Cust cust = null;
		String next = "cdetail.jsp";
		try {
			cust = biz.get(id);
			request.setAttribute("dc", cust);
		}catch(Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher(next);
		rd.forward(request, response);
	}

}
