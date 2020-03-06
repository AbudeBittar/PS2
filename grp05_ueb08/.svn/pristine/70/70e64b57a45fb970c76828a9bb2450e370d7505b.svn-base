/**
 * enthält die eigentliche Spiellogik
 */
package logic;

/**
 * 
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 * 
 */
public class GameTicTacToe {

    /**
     * Name of the players in an array. Length must be 2.
     */
    private String[] players;
    
    /**
     * Index of the player. Must be either 0 or 1.
     */
    private int idxCurrPlayer;
    
    /**
     * Connection to the gui.
     */
    private GUIConnector gui;
    
    /**
     * Saves the state of the current game
     */
    private Symbol[][] field;

    /**
     * Dimension des Spielfelds
     */
    private final int size;
    
    /**
     * Name der Gewinner
     */
    private String winnerPlayer = null;
    
    /**
     * Enum for the symbols used by the players. The ordinal value of the
     * respective symbol of a player should correspond with the index of this
     * player in the player array. The additional value "EMPTY" (marking an
     * empty cell) thus has the highest ordinal value. Visibility should be as
     * restricted as possible.
     */
    public enum Symbol {
        X,
        O,
        EMPTY;
    }

    /**
     * The 2-dimensional field on which the player play.
     *
     * @param players übergebes Array mit den Namen der Spieler
     * @param field das Spielfeld
     * @param gui Kontakt zum Gui
     */
    public GameTicTacToe(String[] players, Symbol[][] field, GUIConnector gui) {
        this.players = players;
        this.size = field.length;
        this.field = field;
        this.gui = gui;
    }

    /**
     * Constructor for a game of tic tac toe. Initializes the field.
     *
     * @param p1 name of the first player
     * @param p2 name of the second player
     * @param size size of the game field
     * @param gui connection to the gui
     */
    public GameTicTacToe(String p1, String p2, int size, GUIConnector gui) {
        this.players = new String[]{p1, p2};
        this.idxCurrPlayer = 0;
        this.field = new Symbol[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.field[i][j] = Symbol.EMPTY;
            }
        }
        this.size = size;
        this.gui = gui;
    }

    /**
     * Handles the turn of a player. If the cell chosen by the player is not
     * empty, nothing happens (the player can chose another cell). If it was
     * empty, the symbol of the current player is placed and the update of the
     * gui is initiated. Then the current player is changed, so that it is the
     * turn of the next player. Finally, the method checks if through this turn
     * a player has won the game.
     *
     * @param coord coordinate in the field at which the player wants to place
     * his/her symbol, length must be 2 otherwise program terminates through
     * assert
     */
    public void playerTurn(int[] coord) {
        if(field[coord[0]][coord[1]] == Symbol.EMPTY) {
            field[coord[0]][coord[1]] = GameTicTacToe.Symbol.values()[idxCurrPlayer];     
            gui.displaySymbol(coord, Symbol.values()[idxCurrPlayer]);
            handleEndOfGame();
            idxCurrPlayer = (idxCurrPlayer + 1) % 2;
            gui.setCurrentPlayer(players[idxCurrPlayer], Symbol.values()[idxCurrPlayer]);
        }
    }

    /**
     * Prüfe ob der Spieler mit dem übergebenen Index gewonnen hat, oder eben nicht
     * @param idxCurrPlayer Index des zu prüfenden Spielers
     * @return Name des Gewinners
     */
    private String findWinner(int idxCurrPlayer) {
        boolean negDiagResult = true;
        boolean posDiagResult = true;
        boolean horizonResult = false;
        boolean verticalResult = false;
        Symbol currPlayerSym = GameTicTacToe.Symbol.values()[idxCurrPlayer];
        
        // Diagonal
        for (int i = 0; i < size && (negDiagResult || posDiagResult); i++) {
            negDiagResult = negDiagResult && (field[i][i] == currPlayerSym);
            posDiagResult = posDiagResult && (field[i][(size - 1) - i] == currPlayerSym);
        }

        // Vertikal
        for (int j = 0; j < size && !(verticalResult); j++) {
            verticalResult = true;
            for (int k = 0; k < size; k++) {
                verticalResult = verticalResult && (field[k][j] == currPlayerSym);
            }
        }
        
        // Horizonal
        for (int j = 0; j < size && !(horizonResult); j++) {
            horizonResult = true;
            for (int l = 0; l < size; l++) {
                horizonResult = horizonResult && (field[j][l] == currPlayerSym);
            }
        }
        
         // Falls mindestens einer der Fälle zutrifft (dieser Spieler hat gewonnen)
        if (negDiagResult || posDiagResult || horizonResult || verticalResult){
            return players[idxCurrPlayer];
        }
        
        // Falls keiner der Fälle zutrifft (alles anders, also dieser Spieler hat nicht gewonnen)
        else {
            return null;
        }
    }
    
    /**
     * Überprüft, ob das Spiel gewonnen wurde oder kein Spielzug mehr möglich ist 
     * und teilt in diesen Fällen dies der GUI mit. Falls das Spiel noch nicht beendet
     * ist geschieht nichts
     */
    protected void handleEndOfGame() {
        winnerPlayer = findWinner(this.idxCurrPlayer);
        if (winnerPlayer == null) {
            if (!emptyCellsLeft()) {
                gui.onGameEnd(null);
            }
        } else {
            gui.onGameEnd(winnerPlayer);
        }
    }
    
    /**
     * ermittelt, ob es noch leere Zellen gibt
     * @return true, wenn mindestens eine Zeille noch übrig ist. 
     */
    protected boolean emptyCellsLeft() {
        //Hierbei sollen nur so viele Zellen wie nötig überprüft werden
        boolean result = false;
        for (int i = 0; i < size && !result; i++) {
            for (int j = 0; j < size && !result; j++) {
                result = field[i][j] == Symbol.EMPTY;
            }
        }
        return result;
    }

    /**
     * liefert den Namen des Gewinners 
     * @return den Namen des Gewinners oder null, fall noch keiner das Spiel gewonnen hat
     */
    protected String getWinnerName() {
        this.winnerPlayer = findWinner(0);
        if(this.winnerPlayer == null){
            this.winnerPlayer = findWinner(1);
        }
         return this.winnerPlayer;
    }

    /**
     * liefert eine Repräsentation des Spielfeldes
     * 
     * °°° Die Werte sollen auf der Breite von 5 ausgegeben werden, jedem Wert folgt ein
     * Leerzeichen und nach jeder Reihe erfolgt ein Zeilenumbruch, so dass einfach
     * übersichtliche Spalten entstehen. Diese Methode soll ausschließlich zum 
     * Testen genutzt werden.
     * 
     * @return alle Eingaben des Feldes als String
     */
    String fieldToString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                str += String.format("%5s ", field[j][i].toString());
            }
            str += "\n"; 
        }
        return str;
    }

}
