package service;

import pojo.BowlingSet;
import pojo.Player;
import pojo.Scoreboard;

import java.util.List;
import java.util.Map;

/**
 * Created by prabinb on 12/05/17.
 */
public class ScoreboardServiceImpl implements ScoreboardService {


    @Override
    public void setNextPlayer(Scoreboard scoreboard) throws Exception {
        List<Player> players = scoreboard.getPlayers();
        Player currentPlayer = scoreboard.getCurrentPlayer();

        Map<Player, List<BowlingSet>> setMap = scoreboard.getSetMap();

        Player nextPlayer = null;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i) == currentPlayer) {
                if (i == players.size() - 1) {
                    nextPlayer = players.get(0);
                    if (scoreboard.getCurrentSetIndex() == scoreboard.getGametype().totalNumberOfSets - 1) {

                    }
                    scoreboard.setCurrentSetIndex(scoreboard.getCurrentSetIndex() + 1);
                } else {
                    nextPlayer = players.get(i + 1);
                }
                break;
            }
        }
        if (nextPlayer == null) {
            throw new Exception("player not found");
        }
        scoreboard.setCurrentPlayer(nextPlayer);


    }
}
