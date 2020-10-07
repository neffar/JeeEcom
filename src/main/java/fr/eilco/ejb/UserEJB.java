package fr.eilco.ejb;

import fr.eilco.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Stateless EJB Session
 * Implements both interfaces Local and Remote
 * <p>
 * Types: Stateless; Stateful; Singleton
 */
@Stateless(name = "UserJNDI")
public class UserEJB implements UserEJBRemote, UserEJBLocal {

    @PersistenceContext(unitName = "userManager")
    EntityManager entityManager;

    public String direBonjour(String name) {
        return "Bonjour " + name;
    }

    public User direBonjourEntity() {
        Query q = entityManager.createQuery("select u from User u");
        return (User) q.getSingleResult();
    }

    public String direBonjourEntity2() {
        Query q = entityManager.createQuery("select u.login from User u where u.id =: id")
                .setParameter("id", 1);
        return (String) q.getSingleResult();
    }
}
