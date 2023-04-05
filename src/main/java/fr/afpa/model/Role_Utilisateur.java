package fr.afpa.model;

import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Role_Utilisateur")
public class Role_Utilisateur {
	@Id
	private Integer id_role;
	private String libelle;
	
    @OneToMany(cascade = {
            CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "role_Utilisateur")
    private List<Utilisateur> utilisateurList = new ArrayList<>();
	
    
	public Role_Utilisateur(Integer idRole, String libelle) {
		super();
		this.id_role = idRole;
		this.libelle = libelle;
	} 
    
	public Role_Utilisateur() {
		
	}


	public Integer getIdRole() {
		return id_role;
	}

	public void setIdRole(Integer idRole) {
		this.id_role = idRole;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public List<Utilisateur> getUtilisateurList() {
		return utilisateurList;
	}



	public void setUtilisateurList(List<Utilisateur> utilisateurList) {
		this.utilisateurList = utilisateurList;
	}
	
	
	
}
