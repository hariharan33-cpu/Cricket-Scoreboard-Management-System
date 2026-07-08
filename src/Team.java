import java.util.ArrayList;

public class Team {

    private String teamName;

    private ArrayList<Player> players;


    // Constructor
    public Team(String teamName) {

        this.teamName = teamName;
        players = new ArrayList<>();

    }


    // Add player dynamically
    public void addPlayer(Player player) {

        players.add(player);

    }


    public String getTeamName() {

        return teamName;

    }


    public ArrayList<Player> getPlayers() {

        return players;

    }


    // Get batsmen list
    public ArrayList<Batsman> getBatsmen() {

        ArrayList<Batsman> batsmen = new ArrayList<>();

        for(Player p : players) {

            if(p instanceof Batsman) {

                batsmen.add((Batsman)p);

            }

        }

        return batsmen;

    }


    // Get bowlers list
    public ArrayList<Bowler> getBowlers() {

        ArrayList<Bowler> bowlers = new ArrayList<>();

        for(Player p : players) {

            if(p instanceof Bowler) {

                bowlers.add((Bowler)p);

            }

        }

        return bowlers;

    }



    // Display complete team squad
    public void displayTeam() {


        System.out.println("\nTeam : " + teamName);

        System.out.println("-------------------------");


        for(Player p : players) {

            p.displayPlayerInfo();

            System.out.println();

        }

    }

}