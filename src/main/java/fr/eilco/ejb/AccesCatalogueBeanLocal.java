package fr.eilco.ejb;

import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;

import javax.ejb.Local;
import java.util.List;

@Local
public interface AccesCatalogueBeanLocal {
    public List<Categorie> getListCategories();
    public List<Produit> getListProduits(int id);
}
