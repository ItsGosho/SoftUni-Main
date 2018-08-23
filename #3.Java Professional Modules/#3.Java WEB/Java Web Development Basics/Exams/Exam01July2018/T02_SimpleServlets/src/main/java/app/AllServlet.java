package app;

import app.db.DB;
import app.db.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/all")
public class AllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Product product : DB.getProducts()) {
            resp.getWriter().println("<a href=\"/products/details?productName="+product.getName()+"\">"+product.getName()+"</a>");
        }
    }


}
