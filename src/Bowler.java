public class Bowler extends Player {

    private int ballsBowled;
    private int runsConceded;
    private int wickets;



    public Bowler(int id, String name, int age) {
        super(id, name, age);
        ballsBowled = 0;
        runsConceded = 0;
        wickets = 0;
    }


    // performance after every ball
    public void bowlBall(int runs, boolean wicket) {

        ballsBowled++;

        runsConceded += runs;

        if (wicket) {
            wickets++;
        }
    }


    // Get overs
    public String getOvers() {

        int overs = ballsBowled / 6;
        int balls = ballsBowled % 6;

        return overs + "." + balls;
    }


    public int getBallsBowled() {
        return ballsBowled;
    }


    public int getRunsConceded() {
        return runsConceded;
    }


    public int getWickets() {
        return wickets;
    }


    // Economy rate
    public double getEconomy() {

        double overs = ballsBowled / 6.0;

        if (overs == 0) {
            return 0;
        }

        return runsConceded / overs;
    }


    // Polymorphism - over ridding
    @Override
    public void displayPerformance() {

        System.out.println(
                getName() +
                        " | Overs: " + getOvers() +
                        " | Runs conceeded by the bowler: " + runsConceded +
                        " | Wickets Taken by the Bowler: " + wickets +
                        " | Economy of the Bowler: " +
                        String.format("%.2f", getEconomy())
        );
    }
}