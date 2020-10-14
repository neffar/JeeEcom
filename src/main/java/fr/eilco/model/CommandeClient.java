package fr.eilco.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "commande_client")
public class CommandeClient implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "montant")
    private float montant;
    @Column(name = "date_creation")
    private Timestamp dateCreation;
    @Column(name = "no_confirmation")
    private float noConfirmation;
    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    @OneToMany(targetEntity = ProduitCommande.class, mappedBy = "commandeClient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProduitCommande> produitCommandes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public float getNoConfirmation() {
        return noConfirmation;
    }

    public void setNoConfirmation(float noConfirmation) {
        this.noConfirmation = noConfirmation;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProduitCommande> getProduitCommandes() {
        return produitCommandes;
    }

    public void setProduitCommandes(List<ProduitCommande> produitCommandes) {
        this.produitCommandes = produitCommandes;
    }

    @Override
    public String toString() {
        return "CommandeClient{" +
                "id=" + id +
                ", montant=" + montant +
                ", dateCreation=" + dateCreation +
                ", noConfirmation=" + noConfirmation +
                ", client=" + client +
                ", produitCommandes=" + produitCommandes +
                '}';
    }
}
