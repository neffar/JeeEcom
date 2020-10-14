package fr.eilco.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produit_commande")
public class ProduitCommande implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "quantite")
    private int quantite;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commande_client_id")
    private CommandeClient commandeClient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public CommandeClient getCommandeClient() {
        return commandeClient;
    }

    public void setCommandeClient(CommandeClient commandeClient) {
        this.commandeClient = commandeClient;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "ProduitCommande{" +
                "id=" + id +
                ", quantite=" + quantite +
                ", commandeClient=" + commandeClient +
                ", produit=" + produit +
                '}';
    }
}
