package cm.geolocalisation.tripcity.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cm.geolocalisation.tripcity.entities.*;
import cm.geolocalisation.tripcity.forms.ConnexionForm;
import cm.geolocalisation.tripcity.dao.SuperviseurDao;
import cm.geolocalisation.tripcity.dao.DAOFactory;

import javax.servlet.annotation.WebServlet;

@WebServlet("/connection")
@SuppressWarnings("serial")
public class ConnectionServlet extends HttpServlet {
	
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String VUE = "/WEB-INF/connection.jsp";
	public static final String ATT_USER = "user";
	public static final String ATT_SESSION_USER = "userSession";
	public static final String ATT_CONNEXION_FORM = "connexionForm";
	
	private SuperviseurDao utilisateurDao;
	public static Superviseur utilisateurTrouve;
	
	public void init() throws ServletException {
		this.utilisateurDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSuperviseurDao();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		ConnexionForm connexionForm = new ConnexionForm();
		Superviseur user = connexionForm.connectUser(request);
		utilisateurTrouve = utilisateurDao.trouver(user);
		HttpSession session = request.getSession();
		request.setAttribute(ATT_CONNEXION_FORM, connexionForm);
		request.setAttribute(ATT_USER, user);
		/*
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean utilisateur à la session,
		 * sinon suppression du bean de la session
		 * */
		if(connexionForm.getErrors().isEmpty() && utilisateurTrouve != null) {
			session.setAttribute(ATT_SESSION_USER, utilisateurTrouve);
			response.sendRedirect(request.getContextPath() + "/list_cites");
		} else {
			session.setAttribute(ATT_SESSION_USER, null);
			this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		}
	}
}
