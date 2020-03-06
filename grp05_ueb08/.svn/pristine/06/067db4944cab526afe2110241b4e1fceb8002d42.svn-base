/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import logic.GameTicTacToe;

/**
 *
 * @author Jan R. Neumann & Abdulrahman Al Bittar
 */
public class FXMLDocumentController implements Initializable {
    
    int FIELD_SIZE = 3;
    
    @FXML
    private GridPane grdPane;
    
    @FXML
    private Button btn00;
    
    @FXML
    private Button btn10;
    
    @FXML
    private Button btn20;
    
    @FXML
    private Button btn01;
    
    @FXML
    private Button btn11;
    
    @FXML
    private Button btn21;
    
    @FXML
    private Button btn02;
    
    @FXML
    private Button btn12;
    
    @FXML
    private Button btn22;
    
    @FXML
    private Label lblCurrPlayer;
    
    @FXML
    private Label lblWinner;
    
    private GameTicTacToe game;
    
    @FXML
    private Button btnNewGame;
    @FXML
    private Label lblNamePlayer1;
    @FXML
    private TextField txtFld1;
    @FXML
    private Label lblNamePlayer2;
    @FXML
    private TextField txtFld2;
    @FXML
    private Button btnStartGame;
    @FXML
    private Label lblCurrPlayerHeader;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnNewGame.setDisable(true);
        lblCurrPlayerHeader.setDisable(true);
        lblCurrPlayer.setDisable(true);
        lblWinner.setVisible(false);
        Button[][] btnsGamePlay = {
            {btn00, btn10, btn20},
            {btn01, btn11, btn21},
            {btn02, btn12, btn22}};
        for (int x = 0; x < FIELD_SIZE; x++) {
            for (int y = 0; y < FIELD_SIZE; y++) {
                GridPane.setColumnIndex(btnsGamePlay[x][y], x);
                GridPane.setRowIndex(btnsGamePlay[x][y], y);
            }
        }
    }    

    /**
     * Event für die Buttons des Spielfelds. Initiert den Zug des momentanen
     * Spielers und im Falle eines korrekten Spielzugs leitet den nächsten Zug ein.
     * @param event es wird mit Button des Spielfelds interagiert
     */
    @FXML
    private void handleBtnGamePlay(ActionEvent event) {
        Button btn = ((Button)event.getSource());
        int[] coord = {GridPane.getColumnIndex(btn),
                       GridPane.getRowIndex(btn)};
        game.playerTurn(coord);
    }

    /**
     * Event für den Button btnNewGame. Beendet das bereits laufende oder 
     * abgeschlossene Spiel und ermöglicht das Starten eines neuen Spiels
     * @param event es wird mit Button btnNewGame interagiert
     */
    @FXML
    private void handleBtnNewGame(ActionEvent event) {
        grdPane.setDisable(true);
        lblWinner.setDisable(true);
        btnStartGame.setVisible(true);
        lblNamePlayer1.setVisible(true);
        lblNamePlayer2.setVisible(true);
        txtFld1.setVisible(true);
        txtFld2.setVisible(true);
        Button[][] btnsGamePlay = {
            {btn00, btn10, btn20},
            {btn01, btn11, btn21},
            {btn02, btn12, btn22}};
        for (int x = 0; x < FIELD_SIZE; x++) {
            for (int y = 0; y < FIELD_SIZE; y++) {
                btnsGamePlay[x][y].setText("");
            }
        }
    }

    /**
     * Event für den Button btnStartGame. Liest die Namen der Spieler aus txtFld1 
     * und txtFld2 und startet ein neues Spiel
     * @param event es wird mit Button btnStartGame interagiert
     */
    @FXML
    private void handleBtnStartGame(ActionEvent event) {
        btnStartGame.setVisible(false);
        lblNamePlayer1.setVisible(false);
        lblNamePlayer2.setVisible(false);
        txtFld1.setVisible(false);
        txtFld2.setVisible(false);
        grdPane.setDisable(false);
        btnNewGame.setDisable(false);
        lblCurrPlayerHeader.setDisable(false);
        lblCurrPlayer.setDisable(false);
        lblWinner.setVisible(false);
        lblWinner.setDisable(false);
        Button[][] btnsGamePlay = {
            {btn00, btn10, btn20},
            {btn01, btn11, btn21},
            {btn02, btn12, btn22}}; 
        this.game = new GameTicTacToe(txtFld1.getText(), txtFld2.getText(), 3,
                        new JavaFXGUI(btnsGamePlay, lblCurrPlayer, grdPane,
                                lblWinner, lblCurrPlayerHeader));
        lblCurrPlayer.setText(txtFld1.getText() + " (X)");
    }
    
}
