package app;

import app.db.DB;
import app.db.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/create")
public class CreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<form method=\"post\">");
        resp.getWriter().println("Name:<input type=\"text\" name=\"name\" placeholder=\"name\"><br>");
        resp.getWriter().println("Description:<input type=\"text\" name=\"description\" placeholder=\"description\"><br>");
        resp.getWriter().println("Type:<input type=\"text\" name=\"type\" placeholder=\"type\"><br>");
        resp.getWriter().println("<input type=\"submit\" value=\"Submit\">");
        resp.getWriter().println("</form>");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("type").equals("Food") ||
                    req.getParameter("type").equals("Domestic") ||
                req.getParameter("type").equals("Health") ||
                req.getParameter("type").equals("Cosmetic") ||
                req.getParameter("type").equals("Other")){

            DB.getProducts().add(new Product(req.getParameter("name"),
                    req.getParameter("description"),
                    req.getParameter("type")));

            resp.sendRedirect("/products/all");
        }else{
            resp.sendRedirect("/products/create");
        }
    }
}
