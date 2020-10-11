package fr.eilco.servlets;

import fr.eilco.ejb.UserEJBLocal;
import fr.eilco.model.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserEJBServlet", urlPatterns = "/controller")
public class UserEJBServlet extends HttpServlet {

    @EJB
    UserEJBLocal userUJB;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get params from request
        String login = request.getParameter("login").trim();
        String email = request.getParameter("email").trim();

        userUJB.save(new User(login, email));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        User user = userUJB.findAll();
        User user = userUJB.findById((long) 1);
        request.setAttribute("User", user);
        request.getRequestDispatcher("views/hello2.jsp").forward(request, response);
    }
}
