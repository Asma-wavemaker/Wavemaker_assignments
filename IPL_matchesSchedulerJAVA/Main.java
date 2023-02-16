import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the no of teams:");
        int noOfTeams = sc.nextInt();
        if(noOfTeams<6 ){
            System.out.println("No of teams must be greater than 6. Retry!");
            System.exit(0);
        }
        if(noOfTeams%2 !=0){
            System.out.println("No of teams must be even. Retry! ");
            System.exit(0);
        }

        ArrayList<String> homeGroundsList = new ArrayList<>();
        ArrayList<String> teamNames = new ArrayList<>();
        for (int i = 0; i < noOfTeams; i++) {
            System.out.println("Enter the team: "+(i+1)+ " name");
            teamNames.add(sc.next());
            homeGroundsList.add(teamNames.get(i) + "-Ground");
        }

//        homeGroundsList.forEach((hgl) -> {
//            System.out.println(hgl);
//        });
        System.out.println("The teams in IPL are:");
        System.out.print(teamNames+"\n");
        System.out.println("Matches to be played in the grounds:");
        System.out.print(homeGroundsList+"\n");

        int index = 0;
        ArrayList<ArrayList<String>> teamCombinations = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < noOfTeams; i++) {
            String teamA = teamNames.get(i);
            for (int j = 0 ; j < noOfTeams; j++) {
                String teamB = teamNames.get(j);
                ArrayList<String> temp = new ArrayList<>();
                if (teamA != teamB) {
                    temp.add(teamA);
                    temp.add(teamB);
                    teamCombinations.add(temp);
                    index++;
                }
            }
        }
//        System.out.println(teamCombinations);
        int totalDays = teamCombinations.size();
        ArrayList<ArrayList<String>> scheduleList = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> constTeams=new ArrayList<ArrayList<String>>();
        int midVal=(noOfTeams/2)-1;
        int constTeamsSize=noOfTeams;
        int counter=0;
        ArrayList<Integer> matchesScheduledIndexes = new ArrayList<>();
        while(counter<constTeamsSize & midVal<=totalDays){
            constTeams.add(teamCombinations.get(midVal));
            matchesScheduledIndexes.add(midVal);
            counter++;
            midVal=midVal+noOfTeams;
//            System.out.println(midVal);
        }


        String prev1 = constTeams.get(constTeams.size()-1).get(0);
        String prev2 = constTeams.get(constTeams.size()-1).get(1);



        while(constTeams.size()<teamCombinations.size()){
            for (int i=0; i<teamCombinations.size() ;i++) {
                if(teamCombinations.get(i).get(0)!= prev1 & teamCombinations.get(i).get(1)!=prev2 & teamCombinations.get(i).get(1)!=prev1 & teamCombinations.get(i).get(0)!= prev2 & (!matchesScheduledIndexes.contains(teamCombinations.indexOf(teamCombinations.get(i))))) {
                    constTeams.add(teamCombinations.get(i));
                    prev1=constTeams.get(constTeams.size()-1).get(0);
                    prev2=constTeams.get(constTeams.size()-1).get(1);
                    matchesScheduledIndexes.add(teamCombinations.indexOf(teamCombinations.get(i)));
                }
            }
        }
//        System.out.println(constTeams);
//       System.out.print(matchesScheduledIndexes);
//        System.out.println(matchesScheduledIndexes.size());

        for(int i=0;i<teamCombinations.size();i++){
            scheduleList.add(teamCombinations.get(matchesScheduledIndexes.get(i)));
        }
        Collections.shuffle(scheduleList);
        ArrayList<String> scheduleStadium = new ArrayList<>();

//        SETTING HOME GROUND MATCHES
        for(int i =0; i<scheduleList.size();i++){
            for(int j=0; j<teamNames.size();j++) {
                if( scheduleList.get(i).get(0) == teamNames.get(j)){
                    scheduleStadium.add(homeGroundsList.get(j));
            }
            }
        }

        String startDate = "20/01/2023";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        ArrayList<String> datesSchedule = new ArrayList<>();

        try {
            cal.setTime(sdf.parse(startDate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 56; i++) {
            cal.add(Calendar.DAY_OF_MONTH,1);
            String nextDate = sdf.format(cal.getTime());
            datesSchedule.add(nextDate);
        }

        System.out.println(" THE IPL MATCHES SCHEDULE ");
        for(int i=0;i<teamCombinations.size();i++){
            System.out.print("On " +datesSchedule.get(i)+" : ");
            System.out.print(scheduleList.get(i).get(0) +" VS " +scheduleList.get(i).get(1));
            System.out.print(" will be playing in: "+scheduleStadium.get(i));
            System.out.println();
        }
    }}

