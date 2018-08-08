package org.softuni.fdmc.servlets.users;

import org.softuni.fdmc.data.models.persons.Admin;
import org.softuni.fdmc.data.models.persons.PersonImp;
import org.softuni.fdmc.data.models.persons.User;
import org.softuni.fdmc.data.repos.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/users/register")
public class UserRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");
        int countOfUsers=((UserRepository)this.getServletContext().getAttribute("users")).getAllUsers().size();

        if(!password.equals(confirmPassword)) {
            resp.sendRedirect("/users/register");
            return;
        }
        if(countOfUsers==0){
            PersonImp admin = new Admin(username,password);
            ((UserRepository)this.getServletContext().getAttribute("users")).addUser(admin);

        }else{
            PersonImp user = new User(username, password);
            ((UserRepository)this.getServletContext().getAttribute("users")).addUser(user);
        }

        resp.sendRedirect("/");
    }
}
