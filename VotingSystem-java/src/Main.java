import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


interface Nominee{
        void displayNominees();
}
class NomineeClass implements Nominee{
    private String nomineeName;
    private int nomineeId;
    private String nomineeParty;
     NomineeClass(String nomineeParty, String nomineeName,int nomineeId){
        this.nomineeName=nomineeName;
        this.nomineeId=nomineeId;
        this.nomineeParty=nomineeParty;
    }

    public void displayNominees(){
        System.out.println("Nominee Name: "+nomineeName+"| Nominee Party: "+nomineeParty+"| Nominee ID: "+nomineeId);
    }

}
interface ElectionWinner{
    void winner();
}
class Winner{
    String winner;
    Winner(String winner){
        this.winner = winner;
    }
    void displayWinner(){
        System.out.println("-----The winner of the Elections:"+ this.winner+"-----");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        ArrayList<NomineeClass> nomineeObjects = new ArrayList<>();
        nomineeObjects.add(new NomineeClass ("TRS","KCR",12) );
        nomineeObjects.add(new NomineeClass ("Congress","Rahul Gandhi",13) );
        nomineeObjects.add(new NomineeClass ("BJP","Narendra Modi",14) );
        nomineeObjects.add(new NomineeClass ("AAP","Arvind kejarival",15) );

        System.out.print("Enter the users for voting:");
        n= sc.nextInt();



        HashMap<Integer,String> nominees = new HashMap<>();
        nominees.put(12,"TRS");
        nominees.put(13,"Congress");
        nominees.put(14,"BJP");
        nominees.put(15,"AAP");


        for(NomineeClass main: nomineeObjects ){
            main.displayNominees();
        }

        HashMap<Integer, String> votedDetails = new HashMap<>();
        int counterTRS = 0;
        int counterCongress = 0;
        int counterBJP = 0;
        int counterAAP = 0;

        String userName;
        int userId;
        int userSelectedNomineeId;

        HashMap<Integer, Integer> voteCountDetails = new HashMap<>();

        for(int i = 0 ; i < n ; i++) {
            System.out.print("Enter the user name:");
            userName = sc.next();
            System.out.print("Enter the user id:");
            userId = sc.nextInt();

            if (votedDetails.containsKey(userId)) {
                System.out.println("User already voted for the Nominee");
                System.exit(0);
            }
            votedDetails.put(userId, userName);
            System.out.println("Below are the Nominee's ID you can vote");

            for (HashMap.Entry m : nominees.entrySet()) {
                System.out.print(m.getKey() + ":" + m.getValue() + "\t");
            }
            System.out.println();
            System.out.println("Enter the ID of the nominee you wish to vote");
            userSelectedNomineeId = sc.nextInt();

            if (userSelectedNomineeId == 12) {
                counterTRS++;
            } else if (userSelectedNomineeId == 13) {
                counterCongress++;
            } else if (userSelectedNomineeId == 14) {
                counterBJP++;
            } else {
                counterAAP++;
            }
            voteCountDetails.put(userId,userSelectedNomineeId);
        }
        int maxVotes=0;
        int winnerId=0;
        int count =0;
        System.out.println("--RESULT--");
        System.out.println("TRS received "+counterTRS+" Votes:");
        System.out.println("Congress received "+counterCongress+" Votes:");
        System.out.println("BJP received"+counterBJP+" Votes:");
        System.out.println("AAP received"+counterAAP+" Votes:");



//        Cheking which nominee has the maximum votes
        if(counterTRS > maxVotes){
            maxVotes=counterTRS;
            winnerId=12;
        }
        if(counterCongress > maxVotes){
            maxVotes=counterCongress;
            winnerId=13;
        }
        if(counterBJP > maxVotes){
            maxVotes=counterBJP;
            winnerId=14;
        }
        if(counterAAP > maxVotes){
            maxVotes=counterAAP;
            winnerId=15;
        }


//        checking if its draw
        if(counterTRS == maxVotes)
            count++;
        if(counterCongress == maxVotes)
            count++;
        if(counterBJP == maxVotes)
            count++;
        if(counterAAP == maxVotes)
            count++;


        if(count>1)
            System.out.println("--It is a draw!--");
        else{
            Winner w = new Winner(nominees.get(winnerId));
            w.displayWinner();
        }

        System.out.println("VOTERS LIST:");
        for (HashMap.Entry h: voteCountDetails.entrySet()) {
            if(h.getValue().equals(12))
                System.out.println("USER: "+votedDetails.get(h.getKey())+" | USER ID:" +h.getKey()+"| voted for : TRS");
            else if(h.getValue().equals(13))
                System.out.println("USER: "+votedDetails.get(h.getKey())+"|  USER ID:" +h.getKey()+"| voted for : Congress");
            else if(h.getValue().equals(14))
                System.out.println("USER: "+votedDetails.get(h.getKey())+"| USER ID:" +h.getKey()+"| voted for : BJP");
            else if(h.getValue().equals(15))
                System.out.println("USER: "+votedDetails.get(h.getKey())+"|  USER ID:" +h.getKey()+"| voted for : AAP");
            else
                System.out.println("X--Invalid vote");

        }
    }
}
