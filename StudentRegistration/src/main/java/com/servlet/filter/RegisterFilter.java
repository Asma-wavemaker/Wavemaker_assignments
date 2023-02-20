package com.servlet.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterFilter implements Filter{
    public void init(FilterConfig arg0) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        PrintWriter out=resp.getWriter();

        String name= (request.getParameter("name"));
        int id=Integer.parseInt(req.getParameter("id"));
        String password=request.getParameter("psw");
        String gender_val="";
        String gender=request.getParameter("Gender");
        if(gender=="M")
            gender_val="Male";
        if(gender=="F")
            gender_val="Female";

        CheckRegistered cr = new CheckRegistered();
        int val = cr.checkExists(id);
        if (password.length()>8 & val>=0){
            InsertStudDetails isd = new InsertStudDetails();
            isd.insertrow(id,name,gender);
            out.println("<h2>Registration Successful!!</h2>");
            }
        else
        {
            if(password.length()<8)
                out.println("<h4>Invalid input. Password length must be greater than 8</h4><br>");
            if(val<0)
                out.println("<h4>Student Already Registered!!!</h4>");
        }
        chain.doFilter(req, resp);
    }
    public void destroy() {}
}
class CheckRegistered {
    int id;
    int checkExists(int id) {
        try {
            this.id = id;
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/registerform", "root", "root");
            Statement stmt = conn.createStatement();
            String quer = "select book_name from formdetails where Student_id=" + id;
            ResultSet rs = stmt.executeQuery(quer);
            if (rs.next()) {
                return 1;
            }
        }
        catch (SQLException s) {
            System.out.println(s);
        }
        return -1;
    }
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
//            String query = "insert into formdetails values(" + id + ",\"" + name + "\",\"" + gender +  ");";
            PreparedStatement psmt = conn.prepareStatement("insert into formdetails values (?,?,?)");
            psmt.setInt(1, id);
            psmt.setString(2, name);
            psmt.setString(3, gender);
            res = psmt.executeUpdate();
            System.out.println(res);

        } catch (SQLException s) {
            System.out.println(s);
        }
        return res;
    }
}
