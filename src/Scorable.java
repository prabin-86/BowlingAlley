import java.util.ArrayList;

/**
 * Created by prabinb on 22/04/17.
 */
public interface Scorable {

    public int calcScore(ArrayList<Character> inputs) throws MoveNotSupportedException;

}
