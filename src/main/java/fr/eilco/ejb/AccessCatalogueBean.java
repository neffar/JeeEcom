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
        return null;
    }

    @Override
    public List<Produit> getListProduits(int id) {
        return null;
    }
}
