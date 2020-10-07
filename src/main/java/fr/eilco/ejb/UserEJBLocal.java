package fr.eilco.ejb;

import fr.eilco.model.User;

import javax.ejb.Local;

@Local
public interface UserEJBLocal {

    public String direBonjour(String name);
    User direBonjourEntity();
    String direBonjourEntity2();
}
