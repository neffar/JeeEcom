package fr.eilco.ejb;

import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AccessCatalogueBean implements AccesCatalogueBeanLocal, AccesCatalogueBeanRemote {
    @PersistenceContext(unitName="managerBoutique")
    EntityManager entityManager;

    @Override
    public List<Categorie> getListCategories() {
        List<Categorie> categories = entityManager.createQuery("select c from Categorie c", Categorie.class).getResultList();
        return categories;
    }

    @Override
    public List<Produit> getListProduits(int id) {
        List<Produit> produits = entityManager.createQuery("select p from Produit p", Produit.class).getResultList();
        return produits;
    }
}
