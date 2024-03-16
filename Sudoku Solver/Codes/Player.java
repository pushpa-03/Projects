package player;

public class Player {
    String name;
    int age;

    // Constructor
    public Player(String name, int age) {
        this.name = name;
        this.age = age;

    }

    // Another way of initializing the class members
    public void setPlayerDetails(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public void setPlayerName(String name) {
        this.name = name;
    }

    public String getPlayerName() {
        return this.name;
    }

    public void getPlayerNameAndAge() {
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);
    }

    public void getPlayerDetails() {
        System.out.println("Player Details");
        System.out.println("Name: " + this.name);
        System.out.println("Age: " + this.age);

    }

}
