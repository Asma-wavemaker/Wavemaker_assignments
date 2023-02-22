package com.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterFilter implements Filter{
    FilterConfig config;
    public void init(FilterConfig arg0) throws ServletException {
        config = arg0;
    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        PrintWriter out=resp.getWriter();
        if(req.getParameter("backlogs").equals(config.getInitParameter("backlogs"))){

        String name= (request.getParameter("name"));
        int id=Integer.parseInt(req.getParameter("id"));
        String password=request.getParameter("psw");
        String gender=request.getParameter("Gender");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerform", "root", "root");
            Statement stmt = conn.createStatement();
            String quer = "select COUNT(*) from formdetails where Student_id=" + id;
            ResultSet rs = stmt.executeQuery(quer);
            rs.next();
            int val = rs.getInt(1);
            if (password.length()>8 && val<=0){
                InsertStudDetails isd = new InsertStudDetails();
                int res =isd.insertrow(id,name,gender);
                if(res>0)
                    out.println("<h2>Registration Successful!!</h2>");
            }
            else
            {
                if(password.length()<8)
                    out.println("<h4>Invalid input. Password length must be greater than 8</h4><br>");
                if(val>0)
                    out.println("<h4>Student Already Registered!!!</h4>");
            }
        }
        catch (Exception s) {
            out.println(s);
        }
        chain.doFilter(req, resp);
    }
        else
            out.println("Not eliglible!");
    }
    public void destroy() {}
}

class InsertStudDetails{
    int id;
    String name;
    String gender;
    int res;
    int insertrow(int id,String name,String gender) {
        try {
            this.id = id;
            this.name = name;
            this.gender = gender;
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerform", "root", "root");
            Statement stmt = conn.createStatement();
            PreparedStatement psmt = conn.prepareStatement("insert into formdetails values (?,?,?)");
            psmt.setInt(1, id);
            psmt.setString(2, name);
            psmt.setString(3, gender);
            res = psmt.executeUpdate();

        } catch (SQLException s) {
            System.out.println(s);
        }
        return res;
    }
}
