package player;

/**
 * Stores the player's turn and it's symbol ('X' or 'O').
 */
public class Player {
    private boolean playerX = true;
    private boolean playerO = false;
    private final String playerXSymbol = "X";
    private final String playerOSymbol = "O";

    /**
     * @return 'X' or 'O' according to current's player turn.
     */
    public String getCurrentPlayer() {
        if (playerX) {
            return playerXSymbol;
        }
        return playerOSymbol;
    }

    /**
     * Changes the current player turn (e.g. from 'X' to 'O').
     */
    public void changeCurrentPlayer() {
        if (playerX) {
            playerX = false;
            playerO = true;
        } else {
            playerX = true;
            playerO = false;
        }
    }


}
