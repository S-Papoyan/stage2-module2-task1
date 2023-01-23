package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/add")
public class AddUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        User user = new User(firstName, lastName);
        Warehouse.getInstance().addUser(user);
        request.setAttribute("users", user);
        request.getRequestDispatcher("/add.jsp").forward(request, response);

    }
}
