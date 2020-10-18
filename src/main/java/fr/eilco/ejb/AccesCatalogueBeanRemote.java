package fr.eilco.ejb;

import fr.eilco.model.Categorie;
import fr.eilco.model.Produit;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface AccesCatalogueBeanRemote {
    public List<Categorie> getListCategories();
    public List<Produit> getListProduits(int id);
}
