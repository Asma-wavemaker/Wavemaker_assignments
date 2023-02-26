import java.util.*;


interface Nominee{
        void displayNominees();
}
class NomineeClass implements Nominee{
    private String nomineeName;
    private int nomineeId;
    private String nomineeParty;
     public void setNomineeDetails(String nomineeParty, String nomineeName,int nomineeId){
        this.nomineeName=nomineeName;
        this.nomineeId=nomineeId;
        this.nomineeParty=nomineeParty;
    }
    public String getNomineeName(){
        return nomineeName;
    }
    public int getNomineeId(){
        return nomineeId;
    }
    public String getNomineeParty(){
        return nomineeParty;
    }

    public void displayNominees(){
        System.out.println("Nominee Name: "+nomineeName+"| Nominee Party: "+nomineeParty+"| Nominee ID: "+nomineeId);
    }

}
interface ElectionWinner{

    String getWinner();
}
class Winner implements ElectionWinner{
    String winner;
    void setWinner(String winner){
        this.winner = winner;
    }
    public String getWinner(){
        return winner;
    }

}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Parties available to stand in Elections");
        ArrayList<String> availableParties = new ArrayList<>();
        availableParties.add("TRS");
        availableParties.add("Congress");
        availableParties.add("BJP");
        availableParties.add("AAP");

        HashMap<Integer,String> nominees = new HashMap<>();

            NomineeClass n1 = new NomineeClass();
            n1.setNomineeDetails("TRS","KCR",12);
            nominees.put(n1.getNomineeId(),n1.getNomineeName());
            NomineeClass n2 = new NomineeClass();
            n2.setNomineeDetails("Congress","Rahul Gandhi",13);
            nominees.put(n2.getNomineeId(),n2.getNomineeName());
            NomineeClass n3 = new NomineeClass();
            n3.setNomineeDetails("BJP","Narendra Modi",14);
            nominees.put(n3.getNomineeId(),n3.getNomineeName());
            NomineeClass n4 = new NomineeClass();
            n4.setNomineeDetails("AAP","Arvind",14);
            nominees.put(n4.getNomineeId(),n4.getNomineeName());


        System.out.println(nominees);
        System.out.print("Enter the users for voting:");
        int no= sc.nextInt();
=======


        HashMap<Integer,String> nominees = new HashMap<>();

            NomineeClass n1 = new NomineeClass();
            n1.setNomineeDetails("TRS","KCR",12);
            nominees.put(n1.getNomineeId(),n1.getNomineeName());
            NomineeClass n2 = new NomineeClass();
            n2.setNomineeDetails("Congress","Rahul Gandhi",13);
            nominees.put(n2.getNomineeId(),n2.getNomineeName());
            NomineeClass n3 = new NomineeClass();
            n3.setNomineeDetails("BJP","Narendra Modi",14);
            nominees.put(n3.getNomineeId(),n3.getNomineeName());
            NomineeClass n4 = new NomineeClass();
            n4.setNomineeDetails("AAP","Arvind",14);
            nominees.put(n4.getNomineeId(),n4.getNomineeName());




        System.out.println(nominees);
        System.out.print("Enter the users for voting:");
        int no= sc.nextInt();



        HashMap<Integer, String> votedDetails = new HashMap<>();
        int counterTRS = 0;
        int counterCongress = 0;
        int counterBJP = 0;
        int counterAAP = 0;

        String userName;
        int userId;
        int userSelectedNomineeId;

        HashMap<Integer, Integer> voteCountDetails = new HashMap<>();

        for(int i = 0 ; i < no ; i++) {
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
            Winner w = new Winner();
            w.setWinner(nominees.get(winnerId));
            String win=w.getWinner();
            System.out.println("-----The winner of the Elections:"+ win+"-----");
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