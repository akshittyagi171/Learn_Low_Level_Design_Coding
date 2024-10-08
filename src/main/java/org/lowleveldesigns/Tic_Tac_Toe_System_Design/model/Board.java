package org.lowleveldesigns.Tic_Tac_Toe_System_Design.model;

import com.sun.tools.javac.util.Pair;
import org.lowleveldesigns.Tic_Tac_Toe_System_Design.enums.PieceType;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public int size;
    public PlayingPiece [][] board;

    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public boolean addPiece(int row, int column, PlayingPiece playingPiece){
        if(board[row][column] != null){
            return false;
        }
        board[row][column] = playingPiece;
        return true;
    }

    public List<Pair<Integer, Integer>> getFreeCells(){
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j] == null){
                    Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
                    freeCells.add(rowColumn);
                }
            }
        }
        return freeCells;
    }

    // Method to print the current state of the board
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("_ ");  // Empty cell
                } else if (board[i][j].pieceType == PieceType.X) {
                    System.out.print("X ");  // X piece
                } else if (board[i][j].pieceType == PieceType.O) {
                    System.out.print("O ");  // O piece
                }
            }
            System.out.println();  // Move to the next row
        }
    }
}
