import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by prabinb on 22/04/17.
 */


public class ScoreBoard {

    private ArrayList<Set> sets;

    private Scorable scorable;
    private Set currentSet;

    private boolean scoreBoardFull = false;

    private Iterator<Set> set_iterator;
    private int currentSetNumber = 1;

    private int currentScore = 0;
    private boolean nextPlayerTurn = false;

    ScoreBoard(GamePlayType gamePlayType) {
        this.scorable = ScoringTechFactory.giveScoringTech(gamePlayType.scoring_type);
        this.sets = new ArrayList<Set>();
        for (int i = 0; i < gamePlayType.getNumOfSets() - 1; i++) {
            sets.add(new Set(scorable, SetType.NORMAL_SET));
        }
        if (gamePlayType.isFinalSetDifferent()) {
            sets.add(new Set(scorable, SetType.FINAL_SET));
        } else {
            sets.add(new Set(scorable, SetType.NORMAL_SET));
        }
        set_iterator = sets.iterator();
        if (set_iterator.hasNext()) {
            currentSet = set_iterator.next();
        }
    }

    public int getScore() throws MoveNotSupportedException {
        return this.currentScore;
    }

    public void addMove(Character move) throws NoMoreMovesAllowed {
        this.currentSet.addMove(move);
        this.nextPlayerTurn = false;
        //This function also takes care of reseting the next player, since the next player is dependant on the current set
        // if the set is complete next player can play, if the first value in set is X, next player can play,

        if (this.currentSet.isComplete() || move == 'X') {
            this.nextPlayerTurn = true;
            if (set_iterator.hasNext()) {
                this.currentSet = set_iterator.next();
                this.currentSetNumber++;
            } else {
                this.currentSet = null;
                this.scoreBoardFull = true;
            }
        }
    }

    public boolean isScoreBoardFull() {
        return scoreBoardFull || this.currentSetNumber > this.sets.size();
    }

    public boolean isNextPlayerTurn() {
        return this.nextPlayerTurn;
    }

    public String convertToString() throws MoveNotSupportedException {
        Iterator<Set> set_iterator1 = sets.iterator();
        String res = "";
        int score = 0;
        while (set_iterator1.hasNext()) {
            Set s = set_iterator1.next();
            score += s.getScore();
            res = res + s.convertToString();
        }
        res = res + "-> " + score;
        return res;
    }
}
