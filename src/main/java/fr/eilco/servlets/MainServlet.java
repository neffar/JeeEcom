package fr.eilco.servlets;

import fr.eilco.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "MainServlet", urlPatterns = "/hello")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Initialize httpSession
        //HttpSession httpSession = request.getSession(true);

        // Get params from request
        String login = request.getParameter("login").trim();
        String email = request.getParameter("email").trim();

        // Send response with url params
        // response.sendRedirect("views/hello.jsp?login=" + login + "&?email=" + email);
        // OR
        // request.getRequestDispatcher("views/hello.jsp").forward(request, response);
        // OR by using session
        //httpSession.setAttribute("email", email);

        // Using JavaBeans, dispatch to another view
        User user = new User();
        user.setLogin(login);
        user.setEmail(email);
        request.setAttribute("User", user);
        request.getRequestDispatcher("views/hello2.jsp").forward(request, response);
    }
}
