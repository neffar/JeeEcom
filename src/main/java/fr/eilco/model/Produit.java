package fr.eilco.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "produit")
public class Produit implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "prix")
    private float prix;
    @Column(name = "description")
    private String description;
    @Column(name = "dernier_maj")
    private Timestamp dernierMaj;
    @ManyToOne(fetch = FetchType.LAZY)
    private Categorie categorie;
    @OneToMany(targetEntity = ProduitCommande.class, mappedBy = "produit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProduitCommande> produitCommandes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDernierMaj() {
        return dernierMaj;
    }

    public void setDernierMaj(Timestamp dernierMaj) {
        this.dernierMaj = dernierMaj;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<ProduitCommande> getProduitCommandes() {
        return produitCommandes;
    }

    public void setProduitCommandes(List<ProduitCommande> produitCommandes) {
        this.produitCommandes = produitCommandes;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", description='" + description + '\'' +
                ", dernierMaj=" + dernierMaj +
                ", categorie=" + categorie +
                ", produitCommandes=" + produitCommandes +
                '}';
    }
}
