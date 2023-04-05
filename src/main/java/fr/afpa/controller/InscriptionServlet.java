package fr.afpa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.afpa.model.Utilisateur;
import fr.afpa.model.Role_Utilisateur;
import fr.afpa.service.UtilisateurService;
import fr.afpa.service.Role_UtilisateurService;

/**
 * Servlet implementation class InscriptionServlet
 */
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurService utilisateurService = new UtilisateurService();
	private Role_UtilisateurService role_UtilisateurService = new Role_UtilisateurService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InscriptionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		String email = request.getParameter("emailInscript");
		String password = request.getParameter("mdpInscript");
		String nom = request.getParameter("nomInscript");
		String prenom = request.getParameter("prenomInscript");
		
		if(utilisateurService.findByMailAndPassword(email, password) == null) {
			Utilisateur utilisateur = new Utilisateur(email,password,nom,prenom, role_UtilisateurService.getById(2));
			utilisateurService.add(utilisateur);
			
			this.getServletContext().getRequestDispatcher("/InscriptionReussit.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/BadConnection.jsp").forward(request, response);
		}
		
	}

}
