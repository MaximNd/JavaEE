package com.FormServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Макс on 20.01.2018.
 */
@WebServlet(name = "FormServlet")
public class FormServlet extends HttpServlet {

    private String login = "User";
    private String password = "qwerty";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/form.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        request.setAttribute("login", login.equals(this.login) ? "" : "Incorrect login!");
        request.setAttribute("password", password.equals(this.password) ? "" : "Incorrect password!");
        if (login.equals(this.login) && password.equals(this.password)) {
            response.sendRedirect("/welcome?login=" + login);
        } else {
            processRequest(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
