package logic;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class FakeGUI implements GUIConnector{

    @Override
    public void displaySymbol(int[] coord, GameTicTacToe.Symbol symbol) {
    }

    @Override
    public void setCurrentPlayer(String name, GameTicTacToe.Symbol symbol) {
    }

    @Override
    public void onGameEnd(String winnerName) {
    }
    
}
