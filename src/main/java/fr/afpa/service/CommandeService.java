package fr.afpa.service;

import java.util.List;

import fr.afpa.dao.CommandeDao;
import fr.afpa.model.Commande;

public class CommandeService {
	CommandeDao commandeDAO = new CommandeDao();
    public void create(Commande commande) {
    	commandeDAO.save(commande);
    }
    public List<Commande> findAll(){
        return commandeDAO.findAll();
    }
    public Commande findById(int id){
        return commandeDAO.findById(id);
    }
}
