package player;

import java.util.Scanner;

public class Player {
    String name;
    String emailId;
    String contactNumber;
    String address;
    int age;

    public void setPlayerName(String name) {
        this.name = name;
    }

    public void setPlayerDetails(String name, String emailId, String contactNumber, String address, int age) {
        this.name = name;
        this.address = address;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.age = age;
    }

    public String getPlayerName() {
        return this.name;
    }

    public void getPlayerDetails() {
        System.out.println("Player Name: " + this.name);
        System.out.println("Player Email Id: " + this.emailId);
        System.out.println("Player Address: " + this.address);
        System.out.println("Player Contact Number: " + this.contactNumber);
        System.out.println("Player Age: " + this.age);
    }

    public void setPlayerDetailsFromUserInput(Player p) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter player Details");
        System.out.print("Player name: ");
        String name = scn.nextLine();        
        System.out.print("Contact Number: ");
        String contactNumber = scn.nextLine();
        // System.out.println();
        System.out.print("Address: ");
        String address = scn.nextLine();
        // System.out.println();
        System.out.print("EmailId: ");
        String emailId = scn.nextLine();
        // System.out.println();
        System.out.print("Age: ");
        int age = scn.nextInt();
        // System.out.println();
        p.setPlayerDetails(name, emailId, contactNumber, address, age);

    }

}
