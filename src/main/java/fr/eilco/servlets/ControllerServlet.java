package fr.eilco.servlets;

import fr.eilco.ejb.AccesCatalogueBeanLocal;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;
import fr.eilco.model.Categorie;

@Transactional
@WebServlet(name = "ControllerServlet", urlPatterns = "/controller")
public class ControllerServlet extends HttpServlet {
    @EJB
    AccesCatalogueBeanLocal accessCatalogue;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json");
        Gson gson = new Gson();
//        List<Categorie> listCategories = accessCatalogue.getListCategories();
        Categorie listCategories = accessCatalogue.findCategorieById(1);
        PrintWriter out = response.getWriter();
        out.print(gson.toJson(listCategories));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( "/view/index.jsp" ).forward( request, response );
    }
}
