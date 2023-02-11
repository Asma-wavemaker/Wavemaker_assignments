package Inheritance;
class Game{
    String game;
    public void game_selected(String game){
        this.game=game;
        System.out.println("Game to be played is: "+game);
    }
}
class Team extends Game{
    int no_players;

    public void players(int no_players){
        this.no_players=no_players;
        System.out.println("For the game: "+super.game);
        System.out.println("No of players: "+no_players);
    }
}
class Captain extends Team{
    String Captain;
    void team_captain(String Captain){
        this.Captain=Captain;
        System.out.println("The Captain of the "+game+" team is :"+this.Captain);
    }
}
public class MultipleLevel{
    public static void main(String[] args) {
//        Team t = new Team();
        Captain c = new Captain();
        c.game_selected("FootBall");
        c.players(11);
        c.team_captain("Messi");
    }

}
