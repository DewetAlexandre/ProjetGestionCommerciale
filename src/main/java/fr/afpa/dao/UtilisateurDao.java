package fr.afpa.dao;

import org.hibernate.Query;

import fr.afpa.model.Utilisateur;

public class UtilisateurDao extends Generic<Utilisateur>{
	public UtilisateurDao() {
        super(Utilisateur.class);
    }
	
	public Utilisateur findByMailAndPassword(String mail,String password) {
        Query query = session.getNamedQuery("Utilisateur.findByMailAndPassword");
        query.setParameter("mail",mail);
        query.setParameter("password",password);
        Utilisateur utilisateur = (Utilisateur) query.uniqueResult();
        return utilisateur;
    }
}
