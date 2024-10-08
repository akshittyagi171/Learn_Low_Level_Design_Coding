package org.lowleveldesigns.Tic_Tac_Toe_System_Design.model;

public class Player {

    public String name;
    public PlayingPiece playingPiece;

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public Player(String name, PlayingPiece playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }


}
