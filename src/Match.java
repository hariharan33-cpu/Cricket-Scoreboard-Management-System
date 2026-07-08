import java.util.ArrayList;
import java.util.Random;

public class Match {

    private Team homeTeam;
    private Team awayTeam;

    private String venue;
    private String matchType;

    private Team battingTeam;
    private Team bowlingTeam;

    private int totalRuns;
    private int wickets;

    private Random random;


    // Constructor
    // Constructor
    public Match(Team homeTeam, Team awayTeam) {

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;

        this.venue = "Mepco Cricket Ground";
        this.matchType = "10 Over Match";

        random = new Random();

    }


    // Start match
    // Start match
    public void startMatch() {

        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        System.out.println("Hari's PROJECT CRICKET SCOREBOARD");
        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        System.out.println("Venue : " + venue);
        System.out.println("Format: " + matchType);


        // Home team batting first
        playInnings(homeTeam, awayTeam);

        int firstInningsScore = totalRuns;


        System.out.println("\nTarget For The Opponent Team: " + (firstInningsScore + 1));


        // Away team chasing
        playInnings(awayTeam, homeTeam);

        int secondInningsScore = totalRuns;


        // Display winner
        displayResult(firstInningsScore, secondInningsScore);

    }



    // 10 over innings
    private void playInnings(Team batting, Team bowling) {


        battingTeam = batting;
        bowlingTeam = bowling;


        totalRuns = 0;
        wickets = 0;


        ArrayList<Batsman> batsmen = batting.getBatsmen();

        ArrayList<Bowler> bowlers = bowling.getBowlers();



        System.out.println("\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(batting.getTeamName() + " Batting");
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");


        int striker = 0;
        int nonStriker = 1;


        for(int over = 1; over <= 10; over++) {


            System.out.println("\nOver  : " + over);


            Bowler currentBowler = bowlers.get((over - 1) % bowlers.size());


            for(int ball = 1; ball <= 6; ball++) {


                if(wickets >= batsmen.size() - 1) {

                    break;

                }


                boolean wicket = random.nextInt(10) == 0;


                int[] possibleRuns = {0, 1, 2, 3, 4, 6};


                int outcome = possibleRuns[random.nextInt(possibleRuns.length)];


                if(wicket) {


                    wickets++;


                    batsmen.get(striker).setOut();


                    System.out.println(
                            batsmen.get(striker).getName()
                                    + " OUT"
                    );


                }
                else {


                    int runs = outcome;


                    totalRuns += runs;


                    batsmen.get(striker).playBall(runs);


                    currentBowler.bowlBall(runs,false);



                    System.out.println(
                            batsmen.get(striker).getName()
                                    + " scored Total "
                                    + runs
                                    + " runs"
                    );



                    if(runs % 2 == 1) {


                        int temp = striker;
                        striker = nonStriker;
                        nonStriker = temp;


                    }

                }



                if(wicket) {

                    currentBowler.bowlBall(0,true);


                    if(striker + 1 < batsmen.size()) {

                        striker++;

                    }

                }



            }


            // Change strike after over

            int temp = striker;
            striker = nonStriker;
            nonStriker = temp;



            System.out.println(
                    "Score : "
                            + totalRuns
                            + "/"
                            + wickets
            );

        }


        displayScoreCard();

    }





    // Batting and bowling scorecard

    private void displayScoreCard() {


        System.out.println("\n!!! BATTING SCORECARD !!!");


        for(Batsman b : battingTeam.getBatsmen()) {


            System.out.println(
                    b.getName()
                            + "  Runs:"
                            + b.getRuns()
                            + " Balls:"
                            + b.getBalls()
                            + " SR:"
                            + String.format("%.2f", b.getStrikeRate())
            );


        }



        System.out.println("\n!!! BOWLING SCORECARD !!!");



        for(Bowler b : bowlingTeam.getBowlers()) {


            System.out.println(
                    b.getName()
                            + " Total Overs:"
                            + b.getOvers()
                            + " Total Runs:"
                            + b.getRunsConceded()
                            + " Total Wickets:"
                            + b.getWickets()
            );


        }


    }





    private void displayResult(int score1,int score2) {


        System.out.println("\n!!! RESULT !!!");


        System.out.println(
                homeTeam.getTeamName()
                        + " : "
                        + score1
        );


        System.out.println(
                awayTeam.getTeamName()
                        + " : "
                        + score2
        );


        if(score1 > score2) {

            System.out.println(
                    "Winner : "
                            + homeTeam.getTeamName()
            );

        }
        else if(score2 > score1) {


            System.out.println(
                    "Winner : "
                            + awayTeam.getTeamName()
            );

        }
        else {

            System.out.println("Match Draw");

        }


    }

}