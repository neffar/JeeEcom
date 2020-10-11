package fr.eilco.ejb;

import fr.eilco.model.User;

import javax.ejb.Local;
import java.util.List;

@Local
public interface UserEJBLocal {

    public String direBonjour(String name);
    List<User> findAll();
    public User findById(Long userId);
    public void save(User user);
}
