package gui;

import logic.GUIConnector;
import logic.GameTicTacToe.Symbol; 
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 * This class is responsible for changing the gui when the logic deems it
 * necessary. Created by the gui and then passed as a parameter into the logic.
 * <br>
 * Addtional private or protected methods may be added to this.
 *
 */

/**
 * 
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 * 
 */
public class JavaFXGUI implements GUIConnector {

    /**
     * The buttons of the game field stored in an array (position in the array =
     * position on the surface).
     */
    private Button[][] btnsField;

    /**
     * Label zeigt den Namen des Spielers und sein Zeichen an.
     */
    private Label lblCurrPlayer;
            
    /**
     * GridPane welches das Spielfeld enthällt. Sollte am Ende des Spiels disabled werden.
     */
    private GridPane grdPane;
    
    /**
     * Label welches den Gewinner anzeigt oder das Ergebnis unentschieden ist
     */
    private Label lblWinDisplay;
    
    /**
     * Label welches die Aufschrift 'Current Player:' enthällt. Sollte am Ende
     * eines Spiels disabled werden.
     */
    private Label lblCurrPlayerHeader;
    /**
     * The constructor. Gets passed all components of the gui that may change
     * due to actions in the logic.
     *
     * @param btns the buttons of the game field (can change their text to the
     * symbols of the players)
     * <br>
     * @param lblCurrPlayer
     * @param gridPane
     * @param lblWinDisplay
     * @param lblCurrPHead
     */
    public JavaFXGUI(Button[][] btns, Label lblCurrPlayer, GridPane gridPane, Label lblWinDisplay, Label lblCurrPHead) {
        this.btnsField = btns;
        this.lblCurrPlayer = lblCurrPlayer;
        this.grdPane = gridPane;
        this.lblWinDisplay = lblWinDisplay;
        this.lblCurrPlayerHeader = lblCurrPHead;
    }

    @Override
    public void displaySymbol(int[] coord, Symbol symbol) {
        btnsField[coord[0]][coord[1]].setText(symbol.toString());
    }

    @Override
    public void setCurrentPlayer(String name, Symbol symbol) {
        lblCurrPlayer.setText(name + " (" + symbol + ")");
    }

    @Override
    public void onGameEnd(String winnerName) {
        grdPane.setDisable(true);
        lblCurrPlayer.setDisable(true);
        lblCurrPlayerHeader.setDisable(true);
        if (winnerName == null) {
            lblWinDisplay.setText("It's a Draw!");
        } else {
            lblWinDisplay.setText("Winner is " + winnerName);
        }
        lblWinDisplay.setVisible(true);
    }

}
