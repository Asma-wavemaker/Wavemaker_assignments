package com.servlet.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class RegisterServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Student Registration Form</title></head><body>");
        String name= (request.getParameter("name"));
        int id=Integer.parseInt(request.getParameter("id"));
        out.println(name);
        out.println(id);
        String gender_val="";

        String gender=request.getParameter("Gender");
        if(gender=="M")
            gender_val="Male";
        if(gender=="F")
            gender_val="Female";

        out.println(gender_val);

        String password=request.getParameter("psw");
        out.println(password);


    }
}
