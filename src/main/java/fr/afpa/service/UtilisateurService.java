package fr.afpa.service;
import fr.afpa.model.Utilisateur;

import java.util.List;
import fr.afpa.dao.UtilisateurDao;

public class UtilisateurService {
	private UtilisateurDao utilisateurDao = new UtilisateurDao();

    public void add(Utilisateur utilisateur) {
    	utilisateurDao.save(utilisateur);
    }

    public List<Utilisateur> displayAll() {
        return utilisateurDao.findAll();
    }

    public Utilisateur findById(int idUtilisateur) {
        return utilisateurDao.findById(idUtilisateur);
    }

    public void delete(Utilisateur utilisateur) {
    	utilisateurDao.delete(utilisateur);
    }

    public void update(Utilisateur utilisateur) {
    	utilisateurDao.update(utilisateur);
    }
    
    public Utilisateur findByMailAndPassword(String email, String password) {
        return utilisateurDao.findByMailAndPassword(email,password);
    }

}
