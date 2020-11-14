package fr.eilco.ejb;

import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AccessCatalogueBean implements AccesCatalogueBeanLocal, AccesCatalogueBeanRemote {
    @PersistenceContext(unitName = "managerBoutique")
    EntityManager entityManager;

    @Override
    public Categorie findCategorieById(int id) {
        return entityManager.find(Categorie.class, id);
    }

    @Override
    public List<Categorie> getListCategories() {
        return entityManager.createQuery("select c from Categorie c", Categorie.class).getResultList();
    }

    @Override
    public List<Produit> getListProduits(int id) {
        return entityManager.createQuery("select p from Produit p", Produit.class).getResultList();
    }
}
