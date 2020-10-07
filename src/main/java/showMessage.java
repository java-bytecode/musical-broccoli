import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "showMessage", urlPatterns = "/showMessage")
public class showMessage extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("number1"));
        int num2 = Integer.parseInt(request.getParameter("number2"));
        PrintWriter printWriter = response.getWriter();
        int sum = num1 + num2;
        printWriter.println("Heya! Sum is " + (num1 + num2));

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/squareNumbers");
        request.setAttribute("numberToSquare", sum);
        requestDispatcher.include(request, response);

    }
}
