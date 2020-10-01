package fr.eilco.ejb;

import javax.ejb.Stateless;

@Stateless(name = "UserJNDI")
public class UserEJB implements UserEJBRemote, UserEJBLocal {

    public String direBonjour(String name) {
        System.out.println("Preparation du message pour dire bonjour " + name);
        return "Bonjour " + name;
    }
}
