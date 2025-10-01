package co.jdc.shp.filters;

import java.io.IOException;

import co.jdc.shp.SecurityController;
import co.jdc.shp.model.Account;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = "/checkout")
public class CheckOutFilter implements Filter{

	@Override
	public void doFilter(
			ServletRequest request, 
			ServletResponse response, 
			FilterChain chain)
			throws IOException, ServletException {
		
		var req = (HttpServletRequest)request;
		var session = req.getSession(true);
		
		if(null == session.getAttribute(Account.KEY)) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.sendRedirect(req.getContextPath().concat("/signin"));
			session.setAttribute(SecurityController.KEY, "/checkout");
			return;
		}
		
		// Next Filter
		chain.doFilter(request, response);

	}

}
