package fr.afpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Commande_Produit")
public class Commande_Produit {
	
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id_commande_produit;
    private int quantite;
    
    @ManyToOne
    @JoinColumn(name="id_commande",referencedColumnName = "id_commande")
    Commande commande;

    @ManyToOne
    @JoinColumn(name="id_produit",referencedColumnName = "id_produit")
    Produit produit;
    

	public Commande_Produit(int quantite, Commande commande, Produit produit) {
		super();
		this.quantite = quantite;
		this.commande = commande;
		this.produit = produit;
	}

	public Commande_Produit() {
		
	}
	
	
	public int getId_commande_produit() {
		return id_commande_produit;
	}

	public void setId_commande_produit(int id_commande_produit) {
		this.id_commande_produit = id_commande_produit;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Override
	public String toString() {
		return "Commande_Produit [id_commande_produit=" + id_commande_produit + ", quantite=" + quantite + ", commande="
				+ commande + ", produit=" + produit.toString() + "]";
	}
    
    
    
}
