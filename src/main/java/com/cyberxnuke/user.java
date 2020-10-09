package com.cyberxnuke;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "user")
public class user extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void service(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String password = (String) session.getAttribute("password");

        Cookie[] cookies = request.getCookies();
        String value = null;

        PrintWriter printWriter = null;
        try {
            printWriter = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(Cookie cookie: cookies){
            if(cookie.getName().equals("login")){
                value = cookie.getValue();
            }
        }

        if(!(value == null)) {
            if (value.equals("loggedIn")) {
                printWriter.println("<!DOCTYPE html>");
                printWriter.println("Hello, " + username + " Your password is " + password);
                printWriter.println("<br/><a href=\"logout\">Logout</a>");
            } } else {
                try {
                    response.sendRedirect("login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

    }
}
