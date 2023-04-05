package fr.afpa.service;

import fr.afpa.dao.Role_UtilisateurDao;
import fr.afpa.model.Role_Utilisateur;

public class Role_UtilisateurService {
	
	Role_UtilisateurDao role_UtilisateurDao = new Role_UtilisateurDao();
	
	public void save(Role_Utilisateur role_Utilisateur){
		role_UtilisateurDao.save(role_Utilisateur);
    }
	
	public Role_Utilisateur getById(Integer id){
		return role_UtilisateurDao.findById(id);
    }
}
