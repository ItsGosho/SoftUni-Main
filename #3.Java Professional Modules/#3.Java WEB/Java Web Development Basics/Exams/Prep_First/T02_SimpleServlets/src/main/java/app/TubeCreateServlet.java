package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tubes/create")
public class TubeCreateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1><b>Create Tube</b></h1>");
        resp.getWriter().println("<hr>");
        resp.getWriter().println("<form method=\"post\" action=\"/tubes/details\">");
        resp.getWriter().println("Title: <input type=\"text\" name=\"title\" placeholder=\"Title...\"><br>");
        resp.getWriter().println("<hr>");
        resp.getWriter().println("Description: <input type=\"text\" name=\"description\" placeholder=\"Description...\"><br>");
        resp.getWriter().println("<hr>");
        resp.getWriter().println("Video Link: <input type=\"text\" name=\"videoLink\" placeholder=\"Video Link...\"><br>");
        resp.getWriter().println("<hr>");
        resp.getWriter().println("<input type=\"submit\" value=\"Create Tube\">");
    }
}
