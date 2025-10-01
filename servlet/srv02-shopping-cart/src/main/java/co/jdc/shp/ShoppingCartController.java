package co.jdc.shp;

import java.io.IOException;

import co.jdc.shp.model.Cart;
import co.jdc.shp.model.ProductManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({
	"/cart",
	"/cart/add",
	"/cart/remove",
	"/cart/clear"
})
public class ShoppingCartController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private ProductManager productManager;
	
	@Override
	public void init() throws ServletException {
		if(getServletContext().getAttribute(ProductManager.KEY) instanceof ProductManager pm) {
			this.productManager = pm;
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var requestUrl = req.getServletPath();
		var productId = req.getParameter("productId");
		var fromHome = req.getParameter("fromHome");
		
		var session = req.getSession(true);
		var cart = (Cart)session.getAttribute(Cart.KEY);
		
		if(null == cart) {
			cart = new Cart();
			session.setAttribute(Cart.KEY, cart);
		}
		
		var view = switch(requestUrl) {
			case "/cart" -> "/cart.jsp";
			case "/cart/add" -> {
				var product = productManager.findById(Integer.parseInt(productId));
				if(null != product) {
					cart.addToCart(product);
				}
				yield fromHome != null ? "/index.jsp" : "/cart.jsp";
			}
			case "/cart/remove" -> {
				cart.removeOne(Integer.parseInt(productId));
				yield cart.getTotalItems() == 0 ? "/index.jsp" : "/cart.jsp";
			}
			default -> {
				cart.clear();
				yield "/index.jsp";
			}
		};
		
		getServletContext().getRequestDispatcher(view)
			.forward(req, resp);
	}
}
