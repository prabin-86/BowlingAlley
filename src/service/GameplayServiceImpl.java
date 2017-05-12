package service;

import pojo.Gameplay;

/**
 * Created by prabinb on 12/05/17.
 */
public class GameplayServiceImpl implements GameplayService {
    ScoreboardService scoreboardService = new ScoreboardServiceImpl();

    @Override
    public Gameplay createGame() {

    }

    @Override
    public void play(Gameplay gameplay) {
        //play until gameplay status is "complete"
        while (gameplay.getGameState() != "COMPLETE") {

            this.nextTurn(gameplay);


        }
    }


    private int nextTurn(Gameplay gameplay) throws Exception {


        scoreboardService.setNextPlayer(gameplay.getScoreboard());


        if (gameplay.getScoreboard().setCurrentSetIndex() == gameplay.getScoreboard().getGametype().totalNumberOfSets - 1) {
            gameplay.setGameState("COMPLETE");
        }
        return 0;
    }
}
