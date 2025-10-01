package co.jdc.shp;

import java.io.IOException;

import co.jdc.shp.model.Account;
import co.jdc.shp.model.Cart;
import co.jdc.shp.model.InvoiceManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/checkout")
public class CheckOutController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	private InvoiceManager invoiceManager;
	
	@Override
	public void init() throws ServletException {
		invoiceManager = (InvoiceManager) getServletContext().getAttribute(InvoiceManager.KEY);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var session = req.getSession(true);
		
		Cart cart = (Cart) session.getAttribute(Cart.KEY);
		Account customer = (Account) session.getAttribute(Account.KEY);
		
		var invoice = invoiceManager.create(customer, cart.getItems());
		
		session.removeAttribute(Cart.KEY);
		
		resp.sendRedirect(req.getContextPath()
				.concat("/invoice?id=%s".formatted(invoice.getId())));
	}

}
