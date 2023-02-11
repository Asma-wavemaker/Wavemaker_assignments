import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
class User{
    private String userName;
    private int userId;
    public User (String userName,int userId){
        this.userName=userName;
        this.userId=userId;
    }
    public void displayUserDetails(){
        System.out.println("student name is "+ userName+ " and student id is "+userId);
    }

    public int getUserId() {
        return userId;
    }
    public String toString(){
        return userName +"(" + userId+")";
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<User> userDetails = new ArrayList<User>();

        System.out.println("Enter username and ID");
        userDetails.add(new User(sc.next(),sc.nextInt()));
        System.out.println("Enter username and ID");
        userDetails.add(new User(sc.next(),sc.nextInt()));
        System.out.println("Enter username and ID");
        userDetails.add(new User(sc.next(),sc.nextInt()));

        for(User main: userDetails ){
            main.displayUserDetails();
        }
        Collections.sort(userDetails, new comparator());
        System.out.println("user details are "+userDetails);
    }
}
class comparator implements java.util.Comparator<User>{
    public int compare(User u1,User u2){
        return u1.getUserId()- u2.getUserId();
    }
}
