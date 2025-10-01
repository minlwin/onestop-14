package co.jdc.shp;

import java.io.IOException;

import co.jdc.shp.exceptions.BusinessException;
import co.jdc.shp.model.Account;
import co.jdc.shp.model.AccountManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet({
	"/signin",
	"/signup",
	"/signout"
})
public class SecurityController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public static final String KEY = "SignInReason";
	
	private AccountManager accountManager;
	
	@Override
	public void init() throws ServletException {
		this.accountManager = (AccountManager) getServletContext().getAttribute(AccountManager.KEY);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var path = req.getServletPath();
		
		if("/signout".equals(path)) {
			HttpSession session = req.getSession(true);
			session.invalidate();
			resp.sendRedirect(req.getContextPath());
			return;
		}
		
		getServletContext().getRequestDispatcher("%s.jsp".formatted(path)).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var path = req.getServletPath();
		
		var name = req.getParameter("name");
		var email = req.getParameter("email");
		var password = req.getParameter("password");
		
		try {
			
			Account account = null;
			
			if("/signin".equals(path)) {
				account = accountManager.signIn(email, password);
			} else if ("/signup".equals(path)) {
				account = new Account();
				account.setName(name);
				account.setEmail(email);
				account.setPassword(password);
				accountManager.signUp(account);
			}
			
			HttpSession session = req.getSession(true);
			var reason = (String)session.getAttribute(KEY);
			
			session.setAttribute(Account.KEY, account);
			
			if("/checkout".equals(reason)) {
				getServletContext().getRequestDispatcher(reason).forward(req, resp);
				return;
			}
			
			resp.sendRedirect(req.getContextPath().concat("/invoice"));
			
		} catch (BusinessException e) {
			req.setAttribute("error", e.getMessage());
			getServletContext().getRequestDispatcher("%s.jsp".formatted(path))
				.forward(req, resp);
		}
 		
	}

}
