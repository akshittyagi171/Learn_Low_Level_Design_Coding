package org.lowleveldesigns.Tic_Tac_Toe_System_Design;

public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("Game winner is: " + game.startGame());
    }
}
