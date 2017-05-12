import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by prabinb on 22/04/17.
 */
public class Set {
    private ArrayList<Character> moves;
    private Scorable scorable;
    private SetType setType;

    private int currentScore = 0;

    Set(Scorable scorable, SetType setType) {
        this.scorable = scorable;
        this.moves = new ArrayList<Character>();
        this.setType = setType;
    }

    public String convertToString() {
        String str = "";
        Iterator<Character> moves_iterator = moves.iterator();
        while (moves_iterator.hasNext()) {
            str += moves_iterator.next() + ",";
        }

        return str;
    }

    public int getScore() throws MoveNotSupportedException {
        return this.scorable.calcScore(moves);
    }

    public void addMove(Character move) throws NoMoreMovesAllowed {
        if (!this.isThisMoveAllowed()) {
            throw new NoMoreMovesAllowed();
        }
        this.moves.add(move);
        ArrayList<Character> temp = new ArrayList<Character>();
        temp.add(move);
    }

    private boolean isThisMoveAllowed() {
        if ((moves.size() == 3 && this.setType == SetType.FINAL_SET) || (moves.size() == 2)) {
            return false;
        }
        return true;
    }

    public boolean isComplete() {
        if ((moves.size() == 3 && this.setType == SetType.FINAL_SET) || (moves.size() == 2)) {
            return true;
        }
        return false;
    }
}
