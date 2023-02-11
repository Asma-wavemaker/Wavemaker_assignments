package Polymorphism;
//method overloading
public class Crickett {
    public void cricket(int batsmen,int bowlers){
        System.out.println("In a team batsmen:"+batsmen+"bowlers:"+bowlers);
    }
    public void cricket (int batsmen,int bowlers,int fielders){
        System.out.println("In a team batsmen:"+batsmen+"bowlers:"+bowlers+"fielders:"+fielders);
    }
    public static void main(String[] args) {
        Crickett o1 = new Crickett();
        o1.cricket(5,6);
        o1.cricket(3,5,3);
    }
}
