package org.softuni.fdmc.servlets.cats;

import org.softuni.fdmc.data.models.Cat;
import org.softuni.fdmc.data.models.Order;
import org.softuni.fdmc.data.models.persons.Person;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.OrderRepository;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@WebServlet("/cats/profile")
public class CatsProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order=new Order();
        Person person =
                ((UserRepository)this.getServletContext().getAttribute("users")).getByUsername(req.getSession().getAttribute("username").toString());
        Cat cat = ((CatRepository)this.getServletContext().getAttribute("cats")).getByName(req.getParameter("catName"));
        order.setUser(person);
        order.setCat(cat);
        order.setMadeOn(LocalDateTime.now());
        ((OrderRepository)this.getServletContext()
                .getAttribute("orders"))
                .getOrders()
                .add(order);
        if(person.getClass().getSimpleName().equals("Admin")){
            resp.sendRedirect("/orders/allOrders");
        }else{
            resp.sendRedirect("/");
        }
    }
}
