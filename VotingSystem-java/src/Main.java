import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("Enter the users for voting:");
        n= sc.nextInt();

        HashMap<Integer,String> nominees = new HashMap<>();
        nominees.put(12,"TRS");
        nominees.put(13,"Congress");
        nominees.put(14,"BJP");
        nominees.put(15,"AAP");



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
            System.out.println("Enter the user id");
            userId = sc.nextInt();

            if (votedDetails.containsKey(userId)) {
                System.out.println("User already voted for the Nominee");
                System.exit(0);
            }
            votedDetails.put(userId, userName);
            System.out.println("Below are the Nominees you can vote");

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
        System.out.println(counterAAP);
        System.out.println(counterBJP);
        System.out.println(counterTRS);


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
            System.out.println("It is draw!");
        else
            System.out.println("THE WINNER IS: "+nominees.get(winnerId));

        System.out.println("Voters of the Nominees are:");
        for (HashMap.Entry h: voteCountDetails.entrySet()) {
            if(h.getValue().equals(12))
                System.out.println("USER: "+votedDetails.get(h.getKey())+"  USER ID:" +h.getKey()+" VOTED"+" : TRS");
            else if(h.getValue().equals(13))
                System.out.println("USER: "+votedDetails.get(h.getKey())+"  USER ID:" +h.getKey()+" VOTED"+" : Congress");
            else if(h.getValue().equals(14))
                System.out.println("USER: "+votedDetails.get(h.getKey())+" USER ID:" +h.getKey()+" VOTED"+" : BJP");
            else if(h.getValue().equals(15))
                System.out.println("USER: "+votedDetails.get(h.getKey())+"  USER ID:" +h.getKey()+" VOTED"+" : AAP");
            else
                System.out.println("Invalid vote");
        }

    }
}