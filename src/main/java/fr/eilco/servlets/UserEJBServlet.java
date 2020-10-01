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

@WebServlet(name = "UserEJBServlet")
public class UserEJBServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        String name = request.getParameter("nom");
        String message = "";

        //Connexion JNDI (annuaire pour localiser l'EJB)
        try {
            final Hashtable jndiProperties = new Hashtable();
            jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
            final Context context = new InitialContext(jndiProperties);
            final String appName = "HelloEAR";
            final String moduleName = "HelloEJBProject";

            final String beanName = "HelloEJB";
            final String viewClassName = UserEJBRemote.class.getName();

            UserEJBRemote remote = (UserEJBRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" +
                            beanName + "!" + viewClassName);
            message = remote.direBonjour(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User bean = new User();
        bean.setLogin(message);
        session.setAttribute("beanHello", bean);
        response.sendRedirect("HelloEJB.jsp");
    }
}
