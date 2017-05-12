import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by prabinb on 22/04/17.
 */
public class DefaultScoringTechnique implements Scorable {

    private int totalPins = 10;

    private int spareBonus = 5;
    private int strikeBonus = 10;


    @Override
    public int calcScore(ArrayList<Character> inputs) throws MoveNotSupportedException {
        Iterator<Character> input_iterator = inputs.iterator();
        int score = 0;

        while (input_iterator.hasNext()) {
            Character c = input_iterator.next();
            if (Character.isDigit(c)) {
                score += Character.getNumericValue(c);
            } else if (c == '/') {
                score = 10 + this.spareBonus;
            } else if (c == 'X') {
                score = 10 + this.strikeBonus;
            } else {
                throw new MoveNotSupportedException();
            }
        }
        return score;
    }
}
