package fr.afpa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.afpa.model.Commande_Produit;
import fr.afpa.model.Produit;
import fr.afpa.model.Utilisateur;
import fr.afpa.service.ProduitService;

/**
 * Servlet implementation class PanierServlet
 */
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProduitService produitService = new ProduitService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		List<Commande_Produit>panier = (List<Commande_Produit>) session.getAttribute("panier");
		
		String[] oper = new String[3];
		oper[0] = "plus";
		oper[1] = "moins";
		oper[2] = "retirer";
		request.setAttribute("oper",oper);
		
		List<Produit> listProduit = produitService.findAll();
		request.setAttribute("listProduit",listProduit);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Client/Panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		List<Commande_Produit> panier = (List<Commande_Produit>) session.getAttribute("panier");
		Integer indexElem = Integer.parseInt(request.getParameter("elemPanier"));
		Commande_Produit elemPanier = panier.get(indexElem);
		String operation = request.getParameter("operation");
		
		Integer index;
		
		switch(operation) {
		
		case "plus":
			index = panier.indexOf(elemPanier);
			elemPanier.setQuantite(elemPanier.getQuantite() + 1);
			panier.set(index, elemPanier);
			break;
		case "moins":
			if(elemPanier.getQuantite()>1) {
				index = panier.indexOf(elemPanier);
				elemPanier.setQuantite(elemPanier.getQuantite() - 1);
				panier.set(index, elemPanier);
			}
			else {
				panier.remove(elemPanier);
			}
			break;
		case "retirer":
			panier.remove(elemPanier);
			break;
		}
		
		
		session.setAttribute("panier",panier);
		
		doGet(request, response);
	}

	
	
}
