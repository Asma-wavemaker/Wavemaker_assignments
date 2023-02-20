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
            while (rs.next()) {
                int Student_id = rs.getInt("Student_id");
                String Student_name = rs.getString("Student_name");
                String Gender = rs.getString("Gender");

              out.print(Student_id);
                out.print(Student_name);
                out.print(Gender);
                out.println();

            }
        }
        catch (Exception s){
            out.println(s);
        }

    }
}

