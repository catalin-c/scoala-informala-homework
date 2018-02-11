package main;

import gamelogic.Game;
import player.Player;
import utils.UserInput;

public class Main {
    /**
     * Prints the instructions for the players and saves their input. If their input is the right type,
     * the game logic instructions start. Otherwise the loop continues.
     * It tries to add 'X' or 'O' to the game table. If it succeeds, it prints the updated game table,
     * checks the state of the game and changes the current player.
     * If it doesn't succeed then it warns the player that his input was invalid and continues the loop
     * without changing the player.
     */
    public static void main(String[] args) {
        Game game = new Game();
        Player player = new Player();
        UserInput user = new UserInput();

        while (true) {
            System.out.println("Player " + "'" + player.getCurrentPlayer() +
                               "' enter your move (row[1-3] column[1-3]):");
            int row = 0;
            int column = 0;

            try {
                row = user.getInput();
                column = user.getInput();
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            if(game.addTicTacToeSymbol(row, column, player.getCurrentPlayer())) {
                game.printGame();

                if(game.endOfGame()) {
                    System.out.println("Player '" + player.getCurrentPlayer() + "' won!");
                    break;
                } else if (game.nobodyWon()) {
                    System.out.println("Nobody won!");
                    break;
                }
                player.changeCurrentPlayer();
            } else {
                System.out.println("This move at (" + row + ", " + column + ") is not valid. Try again...");
            }
        }
    }
}
