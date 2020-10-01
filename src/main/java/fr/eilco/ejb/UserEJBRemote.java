package fr.eilco.ejb;

import javax.ejb.Remote;

@Remote
public interface UserEJBRemote {

    public String direBonjour(String name);
}
