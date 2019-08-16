package cm.geolocalisation.tripcity.servlets;

import java.util.List;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cm.geolocalisation.tripcity.entities.*;
import cm.geolocalisation.tripcity.dao.CiteDao;
import cm.geolocalisation.tripcity.dao.DAOFactory;

import javax.servlet.annotation.WebServlet;

@WebServlet("/list_cites")
@SuppressWarnings("serial")
public class ListAllCitiesServlet extends HttpServlet {
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String VUE = "/WEB-INF/list-city.jsp";
	public static final String ATT_CITE = "city";
	public static final String ATT_LISTE_CITES = "listeCites";
	
	public static CiteDao citeDao;
	
	@SuppressWarnings("static-access")
	public void init() throws ServletException {
		this.citeDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getCiteDao();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Cite> listeDesCites = citeDao.lister();
		Map<Long, Cite> mapCites = new HashMap<Long, Cite>();
		for (Cite city : listeDesCites) {
			mapCites.put(city.getCiteId(), city);
        }
		request.setAttribute(ATT_LISTE_CITES, listeDesCites);
		request.setAttribute(ATT_CITE, mapCites);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
}
