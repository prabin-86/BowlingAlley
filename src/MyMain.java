import java.util.Scanner;

/**
 * Created by prabinb on 22/04/17.
 */
public class MyMain {

    public static void main(String[] args) throws NoMoreMovesAllowed, MoveNotSupportedException {
        Scanner sc = new Scanner(System.in);

        int numOfPlayers = sc.nextInt();

        GamePlay gamePlay = new GamePlay(numOfPlayers);

        while (sc.hasNext()) {
            if (gamePlay.isGameOver()) {
                break;
            }
            gamePlay.addMove(sc.next().charAt(0));
            System.out.println(gamePlay.convertToString());
        }
        System.out.println("Thanks for Plalying");
    }
}
