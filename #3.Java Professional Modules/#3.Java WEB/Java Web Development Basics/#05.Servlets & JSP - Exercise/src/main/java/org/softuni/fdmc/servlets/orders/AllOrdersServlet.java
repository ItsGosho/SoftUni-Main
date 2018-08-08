package org.softuni.fdmc.servlets.orders;

import org.softuni.fdmc.data.models.persons.PersonImp;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orders/allOrders")
public class AllOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonImp reqPerson = null;
        try{
           reqPerson= ((UserRepository)this.getServletContext().getAttribute("users")).getByUsername(req.getSession().getAttribute("username").toString());
        }catch (NullPointerException ex){
            resp.sendRedirect("/");
            return;
        }
        if(reqPerson.getClass().getSimpleName().equals("Admin")){
            req.getRequestDispatcher("allOrders.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("/");
        }
    }
}
