import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by prabinb on 22/04/17.
 */
public class GamePlay {

    private ArrayList<Player> players;
    private GamePlayType gamePlayType = new GamePlayType();

    private Player current_player;
    private Iterator<Player> players_iterator;
    private boolean gameOver = false;

    GamePlay(int numOfPlayers) {
        players = new ArrayList<Player>();
        for (int i = 1; i <= numOfPlayers; i++) {
            this.players.add(new Player("Player " + i, this.gamePlayType));
        }
        this.players_iterator = players.iterator();
        if (this.players_iterator.hasNext()) {
            this.current_player = this.players_iterator.next();
        }
    }


    public void addMove(Character move) throws NoMoreMovesAllowed {
        if (this.current_player.isNextPlayerTurn()) {
            if (players_iterator.hasNext()) {
                this.current_player = players_iterator.next();
            } else if (!this.current_player.isScoreBoardFull()) {
                this.players_iterator = players.iterator();
                this.current_player = players_iterator.next();
            } else {
                this.gameOver = true;
                return;
            }
        }
        this.current_player.addMove(move);
    }

    public String convertToString() throws MoveNotSupportedException {
        Iterator<Player> players_iterator1 = players.iterator();
        String res = "";

        while (players_iterator1.hasNext()) {
            res = res + players_iterator1.next().convertToString();
            res = res + "\n";
        }
        return res;
    }

    public boolean isGameOver() {
        return this.gameOver;
    }

}
