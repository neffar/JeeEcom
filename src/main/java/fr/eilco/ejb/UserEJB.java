package fr.eilco.ejb;

import fr.eilco.model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

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

    @SuppressWarnings(value = "unchecked")
    public List<User> findAll() {
        Query q = entityManager.createQuery("select u from User u", User.class);
        return q.getResultList();
    }

    public User findById(Long userId) {
        User user = entityManager.find(User.class, userId);
        if (user == null) {
            throw new EntityNotFoundException("Can't find User for ID " + userId);
        }
        return user;
    }

    public void save(User user) {
        entityManager.persist(user);
    }
}
