package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/cats/profile")
public class CatProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();

        if (httpSession.getAttribute("name")!=null) {
            resp.getWriter().println("<h1>Cat - " + httpSession.getAttribute("name") + "</h1>");
            resp.getWriter().println("<hr>");
            resp.getWriter().println("<h2>Breed: " + httpSession.getAttribute("breed") + "</h3>");
            resp.getWriter().println("<h2>Color: " + httpSession.getAttribute("color") + "</h3>");
            resp.getWriter().println("<h2>Number of legs: " + httpSession.getAttribute("numberOfLegs") + "</h3>");
            resp.getWriter().println("<hr>");
            resp.getWriter().println("<a href=\"/goshoweb/index\">Back</a>");
            httpSession.invalidate();
        }else{
            resp.getWriter().println("<h1><b>You can access this page directly only after registration!</h1></b>");
        }
    }
}
