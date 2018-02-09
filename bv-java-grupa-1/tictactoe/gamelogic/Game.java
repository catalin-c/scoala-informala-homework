package gamelogic;

import java.util.ArrayList;
import java.util.List;

public class Game {

    // The spaces in the game that will be replaced with either 'X' or 'O'
    private String spaceOne = " ";
    private String spaceTwo = " ";
    private String spaceThree = " ";
    private String spaceFour = " ";
    private String spaceFive = " ";
    private String spaceSix = " ";
    private String spaceSeven = " ";
    private String spaceEight = " ";
    private String spaceNine = " ";

    private List<String> tableSpaces = new ArrayList<>();

    /**
     * Adds all the spaces in an ArrayList so they can be used easily.
     */
    public Game() {
        tableSpaces.add(spaceOne);
        tableSpaces.add(spaceTwo);
        tableSpaces.add(spaceThree);
        tableSpaces.add(spaceFour);
        tableSpaces.add(spaceFive);
        tableSpaces.add(spaceSix);
        tableSpaces.add(spaceSeven);
        tableSpaces.add(spaceEight);
        tableSpaces.add(spaceNine);
    }

    /**
     * Prints the game table using the fields.
     */
    public void printGame() {
        System.out.println(" " + tableSpaces.get(0) + " | " + tableSpaces.get(1) + " | " + tableSpaces.get(2) + " ");
        System.out.println("-----------");
        System.out.println(" " + tableSpaces.get(3) + " | " + tableSpaces.get(4) + " | " + tableSpaces.get(5) + " ");
        System.out.println("-----------");
        System.out.println(" " + tableSpaces.get(6) + " | " + tableSpaces.get(7) + " | " + tableSpaces.get(8) + " ");
    }

    /**
     * Takes the user input (row and column values).
     * If their values are the allowed ones (they both can't be smaller than 1 or bigger than 3),
     * it transforms the values in a list index. If the space in the list is available, it sets the element in the list
     * to be the symbol given as a parameter ('X' or 'O') and returns true and otherwise false.
     *
     * @param row is the row number given by the user.
     * @param column is the column number given by the user.
     * @param symbol is the symbol that will replace the empty spaces in the game. It will be 'X' or 'O' based
     *               on the current player.
     * @return true if the method successfully added 'X' or 'O' on the game table and otherwise false.
     */
    public boolean addTicTacToeSymbol(int row, int column, String symbol) {
        if (row == 1 && column >= 1 && column <= 3) {
            int location = column - 1;
            if(checkTicTacToeTableSpace(location)) {
                tableSpaces.set(location, symbol);
                return true;
            }
        } else if (row == 2 && column >= 1 && column <= 3) {
            int location = column + 2;
            if(checkTicTacToeTableSpace(location)) {
                tableSpaces.set(location, symbol);
                return true;
            }
        } else if (row == 3 && column >= 1 && column <= 3) {
            int location = column + 5;
            if(checkTicTacToeTableSpace(location)) {
                tableSpaces.set(location, symbol);
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the space in the tableSpaces list (at the index given as a parameter)
     * is available to be switched with an 'X' or 'O'.
     *
     * @param location is the index where the method needs to search.
     * @return a boolean according the space availability.
     */
    private boolean checkTicTacToeTableSpace(int location) {
        if (tableSpaces.get(location).equals(" ")) {
            return true;
        }

        return false;
    }

    /**
     * Checks the state of the game.
     *
     * @return true if any possible TicTacToe combination was made and otherwise false.
     */
    public boolean endOfGame() {
        if (!tableSpaces.get(0).equals(" ") && tableSpaces.get(0).equals(tableSpaces.get(1)) &&
                tableSpaces.get(0).equals(tableSpaces.get(2))) {
            return true;
        } else if (!tableSpaces.get(0).equals(" ") && tableSpaces.get(0).equals(tableSpaces.get(3)) &&
                tableSpaces.get(0).equals(tableSpaces.get(6))) {
            return true;
        } else if (!tableSpaces.get(0).equals(" ") && tableSpaces.get(0).equals(tableSpaces.get(4)) &&
                tableSpaces.get(0).equals(tableSpaces.get(8))) {
            return true;
        } else if (!tableSpaces.get(2).equals(" ") && tableSpaces.get(2).equals(tableSpaces.get(5)) &&
                tableSpaces.get(2).equals(tableSpaces.get(8))) {
            return true;
        } else if (!tableSpaces.get(2).equals(" ") && tableSpaces.get(2).equals(tableSpaces.get(4)) &&
                tableSpaces.get(2).equals(tableSpaces.get(6))) {
            return true;
        } else if (!tableSpaces.get(8).equals(" ") && tableSpaces.get(8).equals(tableSpaces.get(7)) &&
                tableSpaces.get(8).equals(tableSpaces.get(6))) {
            return true;
        } else if (!tableSpaces.get(1).equals(" ") && tableSpaces.get(1).equals(tableSpaces.get(4)) &&
                tableSpaces.get(1).equals(tableSpaces.get(7))) {
            return true;
        } else if (!tableSpaces.get(3).equals(" ") && tableSpaces.get(3).equals(tableSpaces.get(4)) &&
                tableSpaces.get(3).equals(tableSpaces.get(5))) {
            return true;
        }
        return false;
    }

    /**
     * Checks the state of the game.
     *
     * @return true if there aren't any moves left and if nobody won.
     */
    public boolean nobodyWon() {
        if (!tableSpaces.contains(" ")) {
            return true;
        }
        return false;
    }
}
