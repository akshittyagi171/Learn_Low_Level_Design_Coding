package org.lowleveldesigns.Tic_Tac_Toe_System_Design;

import com.sun.tools.javac.util.Pair;
import org.lowleveldesigns.Tic_Tac_Toe_System_Design.enums.PieceType;
import org.lowleveldesigns.Tic_Tac_Toe_System_Design.model.Board;
import org.lowleveldesigns.Tic_Tac_Toe_System_Design.model.Player;
import org.lowleveldesigns.Tic_Tac_Toe_System_Design.model.PlayingPieceO;
import org.lowleveldesigns.Tic_Tac_Toe_System_Design.model.PlayingPieceX;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initializeGame();
    }

    public void initializeGame(){

        // creating 2 players
        players = new LinkedList<>();
        PlayingPieceX crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPieceO noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player1", crossPiece);

        players.add(player1);
        players.add(player2);

        // initializeBoard
        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean noWinner = true;
        while(noWinner){

            // Take out the turn whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            // Get the free space from the Board
            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()){
                noWinner = false;
                continue;
            }

            // read the user input
            System.out.print("Player:" + playerTurn.name + " Enter row, column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            // place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow, inputColumn, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully){
                // player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner( inputRow, inputColumn, playerTurn.playingPiece.pieceType);
            if(winner){
                return playerTurn.name;
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType){
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        // Need to check in row
        for(int i=0; i<gameBoard.size;i++){

            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType){
                rowMatch = false;
            }
        }

        // Need to check in column
        for(int i=0; i<gameBoard.size;i++){

            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType){
                columnMatch = false;
            }
        }

        // Need to check in diagonals
        for(int i=0, j=0; i<gameBoard.size;i++, j++){

            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                diagonalMatch = false;
            }
        }

        // Need to check in anti-diagonal
        for(int i=0, j= gameBoard.size-1; i<gameBoard.size;i++,j--){

            if(gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType){
                antiDiagonalMatch = false;
            }
        }

        // Return true if any match found
        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}
