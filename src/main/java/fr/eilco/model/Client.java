package fr.eilco.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "client")
public class Client implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue
    private int id;
    @Column(name = "nom")
    private String nom;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "adresse")
    private String adresse;
    @OneToMany(targetEntity = CommandeClient.class, mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommandeClient> commandeClients;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public List<CommandeClient> getCommandeClients() {
        return commandeClients;
    }

    public void setCommandeClients(List<CommandeClient> commandeClients) {
        this.commandeClients = commandeClients;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                ", commandeClients=" + commandeClients +
                '}';
    }
}
