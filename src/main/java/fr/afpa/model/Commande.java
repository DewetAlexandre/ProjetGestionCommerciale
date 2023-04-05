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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Commande")
public class Commande {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id_commande;
	private Double montant;
	
	@ManyToOne
	    @JoinColumn(name="utilisateur_id", referencedColumnName = "utilisateur_id")
	    private Utilisateur utilisateur;
		
	@OneToMany(cascade = {
            CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "commande")
    private List<Commande_Produit> commande_produitList = new ArrayList<>();

	
	public Commande(){
		
	}


	public Commande(Double montant, Utilisateur utilisateur) {
		super();
		this.montant = montant;
		this.utilisateur = utilisateur;
	}




	public Integer getIdCommande() {
		return id_commande;
	}


	public void setIdCommande(Integer idCommande) {
		this.id_commande = idCommande;
	}


	public Double getMontant() {
		return montant;
	}


	public void setMontant(Double montant) {
		this.montant = montant;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public List<Commande_Produit> getCommande_produitList() {
		return commande_produitList;
	}


	public void setCommande_produitList(List<Commande_Produit> commande_produitList) {
		this.commande_produitList = commande_produitList;
	}
	
	
	
	



	
}
