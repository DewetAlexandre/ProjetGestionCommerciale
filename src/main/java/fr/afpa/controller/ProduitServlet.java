package fr.afpa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.afpa.model.Produit;
import fr.afpa.service.ProduitService;

/**
 * Servlet implementation class ProduitServlet
 */
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ProduitService produitService = new ProduitService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProduitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Produit> listProduit = produitService.findAll();
		
		request.setAttribute("listProduit",listProduit);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/ListeProduitsAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String libelle = "";
		Integer prix = 0;
		Integer produitId = 0;
		Integer crudId = Integer.parseInt(request.getParameter("crudId"));
		
		if(request.getParameter("libelle") != null) {
			libelle = request.getParameter("libelle");
		}
		if(request.getParameter("prix") != null) {
			prix = Integer.parseInt(request.getParameter("prix"));
		}
		if(request.getParameter("produitId") != null) {
			produitId = Integer.parseInt(request.getParameter("produitId"));
		}


		
		switch(crudId) {
		case 1:
			modifier(libelle,prix,produitId);
			break;
		case 2:
			creer(libelle, prix);
			break;
		case 3:
			supprimer(produitId);
			break;
		}
		
				
		List<Produit> listProduit = produitService.findAll();
		request.setAttribute("listProduit",listProduit);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Admin/ListeProduitsAdmin.jsp").forward(request, response);
		
		
		
		
	}
	
	protected void modifier(String libelle, Integer prix, Integer produitId) {
		Produit produit = produitService.find(produitId);
		produit.setLibelle(libelle);
		produit.setPrix(prix);
		produitService.update(produit);
	}
	
	
	protected void creer(String libelle, Integer prix) {
		Produit produit = new Produit(libelle, prix);
		produitService.addProduct(produit);
	}
	
	
	protected void supprimer(Integer produitId) {
		Produit produit = produitService.find(produitId);
		produitService.delete(produit);
	}
	
	

}
