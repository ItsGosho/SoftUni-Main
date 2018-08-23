package app;

import app.db.DB;
import app.db.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/details/*")
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Product product = DB.getProducts().stream().filter(x->x.getName().equals(req.getParameter("productName"))).findFirst().get();
        resp.getWriter().println("<h1>Name:"+product.getName()+"</h1>");
        resp.getWriter().println("<h1>Description:"+product.getDescription()+"</h1>");
        resp.getWriter().println("<h1>Type:"+product.getType()+"</h1>");
    }
}
