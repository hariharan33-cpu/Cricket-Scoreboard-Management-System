public class Main {

    public static void main(String[] args) {


        // Create Team 1
        Team homeTeam = new Team("Sivakasi Kings");


    homeTeam.addPlayer(new Batsman(1, "Hari", 35));
        homeTeam.addPlayer(new Batsman(2, "Virat", 34));
        homeTeam.addPlayer(new Batsman(3, "Rohith", 24));
        homeTeam.addPlayer(new Batsman(4, "Rahul", 31));
        homeTeam.addPlayer(new Batsman(5, "Surya", 33));
        homeTeam.addPlayer(new Bowler(6, "Bumrah", 30));
        homeTeam.addPlayer(new Bowler(7, "Shami", 33));
        homeTeam.addPlayer(new Bowler(8, "Jadeja", 35));



        // Create Team 2
       Team awayTeam = new Team("rising Madurai");


        awayTeam.addPlayer(new Batsman(9, "Warner", 37));
        awayTeam.addPlayer(new Batsman(10, "Smith", 34));
        awayTeam.addPlayer(new Batsman(11, "Head", 29));
        awayTeam.addPlayer(new Batsman(12, "Maxwell", 35));
        awayTeam.addPlayer(new Batsman(13, "Marsh", 32));


        awayTeam.addPlayer(new Bowler(14, "Starc", 34));
        awayTeam.addPlayer(new Bowler(15, "Cummins", 31));
        awayTeam.addPlayer(new Bowler(16, "Hazlewood", 33));



        // Create Match object

        Match match = new Match(homeTeam, awayTeam);


        // Start simulation

        match.startMatch();

    }

}