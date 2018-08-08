package servlets;

import database.models.Cat;
import database.models.FloatingDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cats/all")
public class CatsAllServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>All Cats</h1>");
        resp.getWriter().println("<hr>");
        FloatingDB.getCats().entrySet().stream().forEach(x->{
            try {
                resp.getWriter().println("<h2>"+x.getKey()+"</h2>");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        resp.getWriter().println("<a href=\"/goshoweb/index\">Back To Home</a><br>");
    }
}
