package fr.eilco.ejb;

import javax.ejb.Stateless;

/**
 * Stateless EJB Session
 * Implements both interfaces Local and Remote
 *
 * Types: Stateless; Stateful; Singleton
 */
@Stateless(name = "UserJNDI")
public class UserEJB implements UserEJBRemote, UserEJBLocal {

    public String direBonjour(String name) {
        return "Bonjour " + name;
    }
}
