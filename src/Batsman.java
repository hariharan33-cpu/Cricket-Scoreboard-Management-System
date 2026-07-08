public class Batsman extends Player {

    private int runs;
    private int balls;
    private int fours;
    private int sixes;
    private boolean out;

    // Constructor
    public Batsman(int id, String name, int age) {
        super(id, name, age);
        runs = 0;
        balls = 0;
        fours = 0;
        sixes = 0;
        out = false;
    }

    // Update batting performance after every ball
    public void playBall(int run) {

        balls++;

        if (run == 4) {
            fours++;
        }

        if (run == 6) {
            sixes++;
        }

        if (run >= 0) {
            runs += run;
        }
    }

    // Mark player as out
    public void setOut() {
        out = true;
    }

    public boolean isOut() {
        return out;
    }


    // Getters
    public int getRuns() {
        return runs;
    }

    public int getBalls() {
        return balls;
    }

    public int getFours() {
        return fours;
    }

    public int getSixes() {
        return sixes;
    }


    // Strike rate
    public double getStrikeRate() {

        if (balls == 0) {
            return 0;
        }
        //decimal for the .digits calcultions
        return (runs * 100.0) / balls;
    }


    // Polymorphism over ridding
    @Override
    public void displayPerformance() {

        System.out.println(
                getName() +
                        " | Runs scored: " + runs +
                        " | Balls faced: " + balls +
                        " | No of 4s hit : " + fours +
                        " | No of 6s hit: " + sixes +
                        " | The Strike Rate of the Player SR: " + String.format("%.2f", getStrikeRate())
        );
    }
}