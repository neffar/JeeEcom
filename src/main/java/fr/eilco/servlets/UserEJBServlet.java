package fr.eilco.servlets;

import fr.eilco.ejb.UserEJBRemote;
import fr.eilco.model.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Hashtable;

@WebServlet(name = "UserEJBServlet", urlPatterns = "/controller")
public class UserEJBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String message = "";

        // Connexion JNDI (annuaire pour localiser l'EJB)
        try {
            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");

            final Context context = new InitialContext(jndiProperties);
            final String appName = "";
            final String moduleName = "jeeEilco-1.0-SNAPSHOT";
            final String distinctName = "UserJNDI";
            final String viewClassName = UserEJBRemote.class.getName();
            final String ejbRemoteJNDIName = "ejb:" + appName + "/" + moduleName + "/" +
                    distinctName + "!" + viewClassName;

            UserEJBRemote remote = (UserEJBRemote) context.lookup(ejbRemoteJNDIName);
            message = remote.direBonjour("FROM EILCO");
        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setLogin(message);
        user.setEmail("test@email.fr");
        request.setAttribute("User", user);
        request.getRequestDispatcher("views/hello2.jsp").forward(request, response);
    }
}
