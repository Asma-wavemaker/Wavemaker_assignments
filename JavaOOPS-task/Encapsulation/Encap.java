package Encapsulation;

class Sports{
    private String game_name;
    public void set_game(String game_name){
        this.game_name=game_name;
    }
    public String get_game(){
        return game_name;
    }

}
class Players extends Sports{
    protected int no_players;
    void set_players(int no_players){
        this.no_players=no_players;
    }

}
class Captain extends Players{
    private String captain;
    int get_players(){
        return no_players;
    }
    void set_captain(String captain){
        this.captain=captain;
    }
    String get_captain(){
        return captain;
    }
}


public class Encap {
    public static void main(String[] args) {
        Captain c = new Captain();
        c.set_game("Football");
        String game=c.get_game();
        System.out.println("The game selected is:"+game);
        c.set_players(11);
        System.out.println("no of players are: "+c.get_players());
        c.set_captain("Messi");
        System.out.println("The captain choosen for the "+game+" match is: "+c.get_captain());
    }
}
