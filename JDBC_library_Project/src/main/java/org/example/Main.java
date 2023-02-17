package org.example;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;
class DisplayBooks {
    public void display(){
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibrarySystemJDBC", "root", "root");
            Statement stmt = conn.createStatement();
            String s = "select * from book_details";
            ResultSet rs = stmt.executeQuery(s);
            while (rs.next()) {
                int bid = rs.getInt("book_id");
                String bname = rs.getString("book_name");
                String bauthor = rs.getString("author");
                int rating = rs.getInt("rating");
                System.out.println("Book ID: " +bid + "| Book name: " + bname + "| Author: " + bauthor + "| Rating: " + rating);

            }
        }
        catch (SQLException s){
            System.out.println(s);
        }
    }
}
class InsertBook{
    int b_id;
    String b_name;
    String author;
    int rating;
    int resCount;
    public int insertBook(int b_id,String b_name,String author,int rating){
        try {
            this.b_id=b_id;
            this.b_name=b_name;
            this.author=author;
            this.rating=rating;
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibrarySystemJDBC", "root", "root");
            Statement stmt = conn.createStatement();
            String query = "insert into book_details values(" + b_id + ",\"" + b_name + "\",\"" + author + "\"," + rating + ");";
            PreparedStatement psmt = conn.prepareStatement("insert into book_details values (?,?,?,?)");
            psmt.setInt(1,b_id);
            psmt.setString(2,b_name);
            psmt.setString(3,author);
            psmt.setInt(4,rating);
            resCount = psmt.executeUpdate();
            System.out.println(resCount);

        }
        catch (SQLException s){
        System.out.println(s);
    }return resCount;
    }

}
class ViewBook{
    int searchBookId;
    void viewBook(int searchBookId){
        try {
            this.searchBookId = searchBookId;
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibrarySystemJDBC", "root", "root");
            Statement stmt = conn.createStatement();
            String quer ="select book_name from book_details where book_id="+searchBookId;
            ResultSet rs =stmt.executeQuery(quer);
            while(rs.next()){
                System.out.println("Book name: "+rs.getString("book_name"));
            }
    }
        catch (SQLException s){
        System.out.println(s);
    }
    }
}
class DeleteBook{
    int delBookId;
    int resCount;
    int deletebook(int delBookId){
        try {
            this.delBookId = delBookId;
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/LibrarySystemJDBC", "root", "root");
            Statement stmt = conn.createStatement();
            resCount = stmt.executeUpdate("delete from book_details where book_id=" + delBookId);
        }
        catch (SQLException s){
        System.out.println(s);
    }return resCount;
    }

}

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 1 to view available books in Library");
        System.out.println("Enter 2 for adding a book in library System");
        System.out.println("Enter 3 for searching a book in library System");
        System.out.println("Enter 4 for deleting a book from Library System");

        System.out.println("Please enter the value to perform any of above operations:");
        int operation = sc.nextInt();

        if(operation==1){
            DisplayBooks db = new DisplayBooks();
            db.display();
        }
        else if (operation == 2) {
            System.out.print("enter book id: ");
            int b_id = sc.nextInt();
            System.out.print("enter book name: ");
            String b_name = sc.next();
            System.out.print("enter author: ");
            String b_author = sc.next();
            System.out.print("enter book rating : ");
            int b_rating = sc.nextInt();

            InsertBook ib = new InsertBook();
            int resultVal=ib.insertBook(b_id,b_name,b_author,b_rating);
            if(resultVal >= 1) {
                System.out.println("record inserted");
                DisplayBooks db = new DisplayBooks();
                db.display();
            }
        }
        else if(operation==3){
            DisplayBooks db = new DisplayBooks();
            db.display();
            System.out.println("Enter the book id you want to search");
            int searchBookId = sc.nextInt();
            ViewBook vb = new ViewBook();
            vb.viewBook(searchBookId);
        }
        else if(operation==4){
            System.out.println("Enter the book id you want to delete");
            int deleteBookId= sc.nextInt();
            DeleteBook db = new DeleteBook();
            int resCount=db.deletebook(deleteBookId);
            if(resCount==0)
                System.out.println("row deletion failed");
            else
                System.out.println("rows deleted");
                DisplayBooks d = new DisplayBooks();
                d.display();
        }
        else
            System.out.println("Invalid entry!");

    }
}