package web.component;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cust.CustBiz;

@WebServlet({ "/CustDeleteServlet", "/cdelete" })
public class CustDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CustBiz biz;
    
    public CustDeleteServlet() {
        super();
        biz = new CustBiz();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			biz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("clist");
	}

}
