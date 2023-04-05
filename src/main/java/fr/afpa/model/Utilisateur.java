package fr.afpa.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
@NamedQuery(name = "Utilisateur.findByMailAndPassword", query = "select u from Utilisateur u where u.email = :mail and u.password= :password")
public class Utilisateur {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer utilisateur_id;
	private String email;
	private String password;
	private String nom;
	private String prenom;
    
	@OneToMany(cascade = {
        CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "utilisateur")
    private List<Commande> commande_List = new ArrayList<>();
    
	@ManyToOne
    @JoinColumn(name="id_role", referencedColumnName = "id_role")
    private Role_Utilisateur role_Utilisateur;
	

    
    
	
	public Utilisateur(String email, String password, String nom, String prenom, Role_Utilisateur role_Utilisateur) {
		super();
		this.email = email;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.role_Utilisateur = role_Utilisateur;
	}
	
	
	
	public Utilisateur() {
		
	}

	


	public Integer getUtilisateur_id() {
		return utilisateur_id;
	}



	public void setUtilisateur_id(Integer utilisateur_id) {
		this.utilisateur_id = utilisateur_id;
	}



	public List<Commande> getCommande_List() {
		return commande_List;
	}



	public void setCommande_List(List<Commande> commande_List) {
		this.commande_List = commande_List;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public Role_Utilisateur getRole_Utilisateur() {
		return role_Utilisateur;
	}



	public void setRole_Utilisateur(Role_Utilisateur role_Utilisateur) {
		this.role_Utilisateur = role_Utilisateur;
	}
	
	
	
}
