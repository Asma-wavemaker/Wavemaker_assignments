package com.servlet.filter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


public class DisplayDetailsServlet  extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerform", "root", "root");
            Statement stmt = conn.createStatement();
            String s = "select * from formdetails";
            ResultSet rs = stmt.executeQuery(s);
            out.println("<html><head><title>Student Registration Form</title></head><body>");
            out.println("<div style=\"background:rgb(247, 240, 232);margin:auto;width:50%;text-align:center\"><h2 style=\"margin-bottom:20px\">Registered Student Details</h2><table style=\"width:100%;text-align:center\"><tr><th>Student_id</th><th>Student_name</th><th>Gender</th></tr>");
            while (rs.next()) {
                int Student_id = rs.getInt("Student_id");
                String Student_name = rs.getString("Student_name");
                String Gender = rs.getString("Gender");
                out.println("<tr><td>"+Student_id+"</td><td>"+Student_name+"</td><td>"+Gender+"</td></tr>");
            }out.println("</table></div></body></html>");
        }
        catch (Exception s){
            out.println(s);
        }

    }
}

