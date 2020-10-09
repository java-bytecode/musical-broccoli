package com.cyberxnuke;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        PrintWriter out = response.getWriter();
        out.println("HELLO!, " + username);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        PrintWriter out = response.getWriter();
        out.println("HELLO!, " + username);
    }

    protected void service(HttpServletRequest request, HttpServletResponse response){
       String username = request.getParameter("username");
       String password = request.getParameter("password");

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("password", password);

        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(!(username == null) && !(password == null)) {
            if (username.equals("admin") && password.equals("password")) {
                Cookie loginCookie = new Cookie("login", "loggedIn");
                response.addCookie(loginCookie);
                printWriter.println("<a href=\"user\">User</a>");
            } else {
                printWriter.println("Invalid Username and password!");
            }
        } else {
            try {
                response.sendRedirect("login.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
