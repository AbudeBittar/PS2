package logic;

import logic.GameTicTacToe.Symbol;

/**
 * Interface used for the logic of the game tic tac toe to communicate with the
 * gui.
 *
 * @author cei
 */
public interface GUIConnector {

    /**
     * Displays a given symbol at a specified cell of the field.
     *
     * @param coord the coordinates at which in the field the given symbol
     * should be displayed
     * @param symbol the symbol, of which the String representation should be
     * displayed
     */
    public void displaySymbol(int[] coord, Symbol symbol);

    /**
     * Sets the name and symbol of the current player on the gui.
     *
     * @param name name of the current player
     * @param symbol symbol of the current player (the String representation is
     * this symbol should be displayed on the gui)
     */
    public void setCurrentPlayer(String name, Symbol symbol);

    /**
     * Called when the game is won by a player. Needs to display the name of the
     * winner on the gui and has to ensure that the user cannot continue playing
     * (e.g. by disabling components). If there is no winner, but there are also
     * no empty fields left, no player has won (but in a way the computer). Then
     * this method can be used to display that "no one" is the winner on the
     * gui.
     *
     * @param winnerName name of the player than won; null if there is no winner
     */
    public void onGameEnd(String winnerName);

}
