package fr.afpa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.afpa.model.*;
import fr.afpa.service.*;

/**
 * Servlet implementation class UtilisateurServlet
 */
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurService utilisateurService = new UtilisateurService();
    /**
     * Default constructor. 
     */
    public ConnexionServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String email = request.getParameter("emailConnect");
		String password = request.getParameter("passwordConnect");
		
		Utilisateur utilisateur = utilisateurService.findByMailAndPassword(email, password);
		if(utilisateur != null) {
			HttpSession session = request.getSession();
			session.setAttribute("utilisateurSession",utilisateur);
			if(utilisateur.getRole_Utilisateur().getIdRole() == 1) {
				this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/AcceuilAdmin.jsp").forward(request, response);
				
			}else {
				List<Commande_Produit> panier = new ArrayList();
				session.setAttribute("panier", panier);
				this.getServletContext().getRequestDispatcher("/WEB-INF/Client/AcceuilClient.jsp").forward(request, response);
			}
		}else {
			this.getServletContext().getRequestDispatcher("/InscriptionServlet.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
	}

}
