package cm.geolocalisation.tripcity.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*")
public class RestrictionFilter implements Filter {
	public static final String ATT_SESSION_USER = "userSession";

	@Override
	public void destroy() { }

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String chemin = request.getRequestURI().substring(request.getContextPath().length());
		if(chemin.startsWith("/CSS")) {
			chain.doFilter(request, response);
			return;
		}
		if(chemin.startsWith("/rest") || chemin.startsWith("/fichiers")) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = request.getSession();
		if(session.getAttribute(ATT_SESSION_USER) == null) {
			request.getRequestDispatcher("/connection").forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException { }

}
