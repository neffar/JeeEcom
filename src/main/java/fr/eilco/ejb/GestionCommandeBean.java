package fr.eilco.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class GestionCommandeBean implements GestionCommandeBeanLocal, GestionCommandeBeanRemote {
    @PersistenceContext(unitName="managerBoutique")
    EntityManager entityManager;

}
