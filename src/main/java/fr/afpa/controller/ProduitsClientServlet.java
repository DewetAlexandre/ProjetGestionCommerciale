package fr.afpa.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.afpa.model.Commande_Produit;
import fr.afpa.model.Produit;
import fr.afpa.service.ProduitService;

/**
 * Servlet implementation class ProduitsClientServlet
 */
public class ProduitsClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitService produitService = new ProduitService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitsClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Produit> listProduit = produitService.findAll();
		
		request.setAttribute("listProduit",listProduit);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Client/Produits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		Integer idProduit = Integer.parseInt(request.getParameter("idProduit"));
		Integer quantite = Integer.parseInt(request.getParameter("quantite"));
		HttpSession session = request.getSession();
		List<Commande_Produit>panier = (List<Commande_Produit>) session.getAttribute("panier");
		System.out.print(idProduit);
		Boolean verif = false;
		if(panier.isEmpty()) {
			panier.add(new Commande_Produit(quantite, null, produitService.find(idProduit)));
			System.out.print(panier.toString());
			verif = true;
		}else {
			for(Commande_Produit cmdprd : panier) {
				if(cmdprd.getProduit().getIdProduit() == idProduit) {
					cmdprd.setQuantite(cmdprd.getQuantite() + quantite);
					verif = true;
				}
			}
		}
		if(verif == false) {
			panier.add(new Commande_Produit(quantite, null, produitService.find(idProduit)));
			System.out.print(panier.toString());
		}
		
		List<Produit> listProduit = produitService.findAll();
		session.setAttribute("panier", panier);
		request.setAttribute("listProduit",listProduit);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Client/Produits.jsp").forward(request, response);
	}

}
