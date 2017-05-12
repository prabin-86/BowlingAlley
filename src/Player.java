/**
 * Created by prabinb on 22/04/17.
 */
public class Player {
    private String name;
    private ScoreBoard scoreBoard;

    Player(String name, GamePlayType gamePlayType) {
        this.name = name;
        this.scoreBoard = new ScoreBoard(gamePlayType);
    }

    public int getScore() throws MoveNotSupportedException {
        return this.scoreBoard.getScore();
    }

    public void addMove(Character move) throws NoMoreMovesAllowed {
        this.scoreBoard.addMove(move);
    }

    public String convertToString() throws MoveNotSupportedException {
        String res = this.name;
        res = res + ": " + this.scoreBoard.convertToString();
        return res;
    }

    public boolean isNextPlayerTurn() {
        return this.scoreBoard.isNextPlayerTurn();
    }

    public boolean isScoreBoardFull() {
        return this.scoreBoard.isScoreBoardFull();
    }

}
