package fr.afpa.service;

import fr.afpa.model.Commande_Produit;
import fr.afpa.dao.Commande_ProduitDao;

public class Commande_ProduitService {
	
	Commande_ProduitDao commandeProduitDao = new Commande_ProduitDao();
	
    public void save(Commande_Produit commande_produit){
    	commandeProduitDao.save(commande_produit);
    }

}
