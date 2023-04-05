package fr.afpa.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Produit")
public class Produit {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer id_produit;
	private String libelle;
    private double prix;
	
    @OneToMany(cascade = {
            CascadeType.PERSIST, CascadeType.REMOVE }, mappedBy = "produit")
    private List<Commande_Produit> commande_produitList = new ArrayList<>();

    
    
	public Produit(String libelle, double prix) {
		super();
		this.libelle = libelle;
		this.prix = prix;
	}
	
	public Produit() {
		
	}

	public Integer getIdProduit() {
		return id_produit;
	}

	public void setIdProduit(Integer idProduit) {
		this.id_produit = idProduit;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public List<Commande_Produit> getCommande_produitList() {
		return commande_produitList;
	}

	public void setCommande_produitList(List<Commande_Produit> commande_produitList) {
		this.commande_produitList = commande_produitList;
	}

	@Override
	public String toString() {
		return id_produit + " -> " + libelle + " -> " + prix;
	}
    
	
    
    
}
