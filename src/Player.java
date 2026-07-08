public abstract class Player {

    private int id;
    private String name;
    private int age;

    // Constructor
    public Player(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getters (Encapsulation)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // is the abstract method declaration
    public abstract void displayPerformance();

    //player details are print :
    public void displayPlayerInfo() {
        System.out.println("ID of the player   : " + id);
        System.out.println("Name of the player : " + name);
        System.out.println("Age of the player  : " + age);
    }
}