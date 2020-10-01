package fr.eilco.ejb;

import javax.ejb.Local;

@Local
public interface UserEJBLocal {

    public String direBonjour(String name);
}
