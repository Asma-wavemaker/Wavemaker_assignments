package Data_Abstraction;
abstract class teams{
    void no_games(int t_games){
        System.out.println("Total games played are:"+t_games);
    }
    abstract void cricket_captain();
    abstract void football_captain();
    abstract void hockey_captain();


}
class team_captains extends teams{

    void team_captains(){
        System.out.println("The Captains of different sports teams are: ");
    }
    String cricket_captain="Virat kohli";
    String football_captain="Messi";
    String hockey_captain="Manpreet";
    void cricket_captain(){
        System.out.println("Cricket team Captain: "+cricket_captain);
    }
    void football_captain(){
        System.out.println("foot_ball team Captain: "+football_captain);
    }
    void hockey_captain(){
        System.out.println("Hockey team Captain: "+ hockey_captain);
    }
}
public class DataAbs extends team_captains {
    public static void main(String[] args) {
        team_captains t1 = new team_captains();
        t1.no_games(3);
        t1.team_captains();
        t1.cricket_captain();
        t1.football_captain();
        t1.hockey_captain();
    }
}
