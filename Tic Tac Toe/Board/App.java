import board.Board;
import player.Player;
import game.Game;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("First Project -> Tic Tac Toe");

        Board b = new Board(3, '-');
        b.printBoardConfig();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Player1 Details");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Symbol: ");
        char symbol = sc.nextLine().charAt(0);

        // String address=sc.nextLine();
        // long contactNumber=sc.nextLong();
        // int age=sc.nextInt();
        // String emailId=sc.nextLine();

        Player p1 = new Player();
        p1.setPlayerNameAndSymbol(name, symbol);
        p1.getPlayerNameAndSymbol();

        System.out.println("Enter the Player2 Details");
        System.out.print("Name: ");
        String name2 = sc.nextLine();
        System.out.print("Symbol: ");
        char symbol2 = sc.nextLine().charAt(0);
        // String address=sc.nextLine();
        // long contactNumber2=sc.nextLong();
        // int age2=sc.nextInt();
        // String emailId2=sc.nextLine();

        Player p2 = new Player();
        p2.setPlayerNameAndSymbol(name2, symbol2);
        p2.getPlayerNameAndSymbol();

        Game game = new Game(new Player[] { p1, p2 }, b);
        game.play();
    }

}
