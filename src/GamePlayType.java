/**
 * Created by prabinb on 22/04/17.
 */
public class GamePlayType {
    ScoringType scoring_type = ScoringType.DEFAULT;

    private int numOfSets = 2;
    private boolean isFinalSetDifferent = true;


    public int getNumOfSets() {
        return numOfSets;
    }

    public boolean isFinalSetDifferent() {
        return isFinalSetDifferent;
    }

}
