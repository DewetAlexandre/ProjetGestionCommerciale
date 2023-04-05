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
		
		List<Produit> listProduit = produitService.findAll();
		request.setAttribute("listProduit",listProduit);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Client/Panier.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		List<Produit> listProduit = produitService.findAll();
		request.setAttribute("listProduit",listProduit);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Client/Panier.jsp").forward(request, response);
	}

}
