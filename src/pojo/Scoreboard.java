package pojo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by prabinb on 12/05/17.
 */
public class Scoreboard {
    List<Player> players;
    Iterator<Player> playerIterator;
    Map<Player, List<BowlingSet>> setMap;
    Player currentPlayer;
    Integer currentSetIndex;
    Gametype gametype;

    public Scoreboard(int numOfPlayers, Gametype gametype) {
        players = new ArrayList<Player>();
        for (int i = 0; i < numOfPlayers; i++) {
            Player player = new Player();
            players.add(player);
        }
        playerIterator = players.iterator();
        currentPlayer = playerIterator.next();
        currentSetIndex = 0;
    }

    public Gametype getGametype() {
        return gametype;
    }

    public void setGametype(Gametype gametype) {
        this.gametype = gametype;
    }

    public Integer getCurrentSetIndex() {
        return currentSetIndex;
    }

    public void setCurrentSetIndex(Integer currentSetIndex) {
        this.currentSetIndex = currentSetIndex;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public Map<Integer, List<BowlingSet>> getSetMap() {
        return setMap;
    }

    public void setSetMap(Map<Integer, List<BowlingSet>> setMap) {
        this.setMap = setMap;
    }

    public Iterator<Player> getPlayerIterator() {
        return playerIterator;
    }

    public void setPlayerIterator(Iterator<Player> playerIterator) {
        this.playerIterator = playerIterator;
    }
}
