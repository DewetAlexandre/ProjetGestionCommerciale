package fr.afpa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.afpa.model.Commande_Produit;
import fr.afpa.model.Utilisateur;
import fr.afpa.model.Commande;
import fr.afpa.service.CommandeService;
import fr.afpa.service.Commande_ProduitService;

/**
 * Servlet implementation class PaiementServlet
 */
public class PaiementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CommandeService commandeService = new CommandeService();
    private Commande_ProduitService commande_ProduitService = new Commande_ProduitService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaiementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Client/Paiement.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateurSession");
		List<Commande_Produit> panier = (List<Commande_Produit>) session.getAttribute("panier");
		
		Commande commande = new Commande();
		commande.setUtilisateur(utilisateur);
		Double prixTotal = (double) 0;
		for(Commande_Produit cmdPrd : panier) {
			prixTotal += cmdPrd.getProduit().getPrix() * cmdPrd.getQuantite();
		}
		commande.setMontant(prixTotal);
		commande.setCommande_produitList(panier);
		
		commandeService.create(commande);
		
		for(Commande_Produit cmdProd : panier) {
			cmdProd.setCommande(commande);
			commande_ProduitService.save(cmdProd);
		}
		
		session.removeAttribute("panier");
		
		request.setAttribute("commande", commande);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Client/CommandeValide.jsp").forward(request, response);
	}

}
