package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Welcome to Fluffy Duffy Munchkin Cats!</h1>");
        resp.getWriter().println("<h4>Navigate through the application using the links below!</h4>");
        resp.getWriter().println("<hr>");
        resp.getWriter().println("<a href=\"/goshoweb/cats/create\">Create Cat</a><br>");
        resp.getWriter().println("<a href=\"/goshoweb/cats/all\">All Cats</a>");
    }
}
