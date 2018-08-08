package org.softuni.fdmc.servlets.cats;

import org.softuni.fdmc.data.models.Cat;
import org.softuni.fdmc.data.models.persons.PersonImp;
import org.softuni.fdmc.data.repos.CatRepository;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cats/create")
public class CatsCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonImp reqPerson = null;
        try{
            reqPerson = ((UserRepository)this.getServletContext().getAttribute("users")).getByUsername(req.getSession().getAttribute("username").toString());
        }catch (IllegalArgumentException ex){
            resp.sendRedirect("/");
            return;
        }
        if(reqPerson.getClass().getSimpleName().equals("Admin")){
            req.getRequestDispatcher("create.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("/");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String breed = req.getParameter("breed");
        String color = req.getParameter("color");
        Integer numberOfLegs = Integer.parseInt(req.getParameter("numberOfLegs"));
        PersonImp creator = ((UserRepository)this.getServletContext().getAttribute("users")).getByUsername(req.getSession().getAttribute("username").toString());

        if(creator.getClass().getSimpleName().equals("Admin")){
            Cat cat = new Cat(name, breed, color, numberOfLegs, creator);

            ((CatRepository)this.getServletContext().getAttribute("cats")).addCat(cat);

            resp.sendRedirect("/cats/profile?catName=" + cat.getName());
        }else{
            resp.sendRedirect("/");
        }
    }
}
