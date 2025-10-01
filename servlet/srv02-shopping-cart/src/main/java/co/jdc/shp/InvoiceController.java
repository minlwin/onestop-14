package co.jdc.shp;

import java.io.IOException;

import co.jdc.shp.model.Account;
import co.jdc.shp.model.InvoiceManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/invoice")
public class InvoiceController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private InvoiceManager invoiceManager;
	
	@Override
	public void init() throws ServletException {
		this.invoiceManager = (InvoiceManager) getServletContext().getAttribute(InvoiceManager.KEY);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var idStr = req.getParameter("id");
		
		var view = "/invoice-list.jsp";
		
		if(null == idStr) {
			var session = req.getSession(true);
			Account customer = (Account) session.getAttribute(Account.KEY);
			
			var list = invoiceManager.findByAccount(customer.getEmail());
			req.setAttribute("list", list);

		} else {
			view = "/invoice-details.jsp";
			var details = invoiceManager.findById(Integer.parseInt(idStr));
			req.setAttribute("details", details);
		}
		
		getServletContext().getRequestDispatcher(view)
			.forward(req, resp);
	}

}
