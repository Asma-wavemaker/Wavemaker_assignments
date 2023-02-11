package Inheritance;
interface Cricket {
        void no_players();
        void teamCaptain();
        }
interface FootBall
{
    void totalPlayers();
    void team_captain();
}
class Sports implements Cricket, FootBall {
    String cricket_captain ="Kohli";
    int totalPlayers=11;
    String football_captain= "Messi";
    int no_players=11;
    public void no_players() {
        System.out.println("Total players in cricket team are: "+no_players);
    }
    public void teamCaptain() {

        System.out.println("The captain of Cricket team is: "+cricket_captain);
    }
    public void totalPlayers() {
        System.out.println("Total players in cricket team are: "+totalPlayers);
    }
    public void team_captain() {
        System.out.println("The captain of Cricket team is: "+football_captain);
    }

}
class Multiple{
    public static void main(String[] args) {
        Sports s = new Sports();


    }
}


