package com.WelcomeServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Макс on 20.01.2018.
 */
@WebServlet(name = "WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        if (login == null) response.sendRedirect("/");
        else {
            response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("login", login);
            request.getRequestDispatcher("/welcome.jsp").forward(request, response);
        }
    }
}
