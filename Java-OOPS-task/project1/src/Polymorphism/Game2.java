//method overriding
package Polymorphism;
class Game1 {
    int batsmen=5;
    int bowlers=3;
    int fielders=3;
    public void no_players(int total_players){
        System.out.println("In first match bowlers:"+bowlers+"batsmen:"+batsmen+"fielders:"+fielders);
    }

}
public class Game2 extends Game1{
    int fielders=4;
    int bowlers= 3;
    int batsmen=4;
    public void no_players(int total_players){
        System.out.println("In Match1 batsmen:"+super.batsmen+"bowlers:"+super.bowlers+"fielders"+super.fielders);
        System.out.println("In Match1 batsmen:"+batsmen+"bowlers:"+bowlers+"fielders"+fielders);
    }
    public static void main(String[] args) {
        Game2 g2 = new Game2();
        g2.no_players(11);
    }
}
