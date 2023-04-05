package fr.afpa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.afpa.model.Commande;
import fr.afpa.model.Utilisateur;
import fr.afpa.service.CommandeService;

/**
 * Servlet implementation class CommandeServlet
 */
public class CommandeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CommandeService commandeService = new CommandeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeServlet() {
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
		HttpSession session = request.getSession();
		List<Commande> commandeList = new ArrayList<>();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurSession");
		if(utilisateur.getRole_Utilisateur().getIdRole() == 2) {
			for(Commande commande : commandeService.findAll()) {
				if(commande.getUtilisateur() == utilisateur){
					commandeList.add(commande);
				}
			}
			request.setAttribute("commandes",commandeList);
			this.getServletContext().getRequestDispatcher("/WEB-INF/Client/Commandes.jsp").forward(request, response);
		}else {
			request.setAttribute("commandes",commandeService.findAll());
			this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/CommandesClients.jsp").forward(request, response);
		}
	}

}
