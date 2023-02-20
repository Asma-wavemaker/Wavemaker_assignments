package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCalculator extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();


        out.println("<html><head><title>Servlet CalculatorServlet</title></head><body>");
        double n1 = Double.parseDouble(request.getParameter("txtN1"));


        double n2 = Double.parseDouble(request.getParameter("txtN2"));
        double result =0;
        String opr=request.getParameter("opr");
        if(opr.equals("+"))
            result=n1+n2;
        if(opr.equals("-"))
            result=n1-n2;
        if(opr.equals("*"))
            result=n1*n2;
        if(opr.equals("/"))
            result=n1/n2;
        if(opr.equals("%"))
            result=n1%n2;

        out.println("<div style=\"width:300px;height:400px;margin:auto;text-align:center;background-color: rgb(188, 213, 213);display: flex;align-items:center\"> ");
        out.println("<h1 style=\"padding:20px;color:blue;margin:auto;background-color: antiquewhite;\">"+n1+opr+n2+"<br> Answer = "+result);
        out.println("</div>");
        out.println("</body></html>");
    }
}
