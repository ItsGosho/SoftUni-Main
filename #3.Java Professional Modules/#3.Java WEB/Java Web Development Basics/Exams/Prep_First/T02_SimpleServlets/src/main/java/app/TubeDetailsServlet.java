package app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/tubes/details")
public class TubeDetailsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1><b>Successfully created Tube - "+req.getParameter("title")+"</b><h1>");
        resp.getWriter().println("<hr>");
        resp.getWriter().println("<h3><b>Description:</b></h3>");
        resp.getWriter().println("<p>"+req.getParameter("description")+"</p>");
        resp.getWriter().println("<hr>");
        resp.getWriter().println("<h3><b>Video Link</b></h3>");
        resp.getWriter().println("<p>"+req.getParameter("videoLink")+"</p>");
    }
}
