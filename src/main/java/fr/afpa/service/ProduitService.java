package fr.afpa.service;
import java.util.List;

import fr.afpa.dao.ProduitDao;
import fr.afpa.model.Produit;

public class ProduitService {
    ProduitDao produitDao = new ProduitDao();
    public void addProduct(Produit produit) {
    	produitDao.save(produit);

    }

    public Produit find(int id){
        return produitDao.findById(id);
    }

    public List<Produit> findAll(){
        return produitDao.findAll();
    }

    public void delete(Produit produit){
    	produitDao.delete(produit);
    }

    public void update(Produit produit) {
    	produitDao.update(produit);
    }
}
