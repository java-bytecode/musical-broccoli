package com.cyberxnuke;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "logout")
public class logout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void service(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("login")){
                cookie.setValue(null);
                cookie.setMaxAge(0);
                session.invalidate();
                try {
                    response.sendRedirect("login.jsp");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
