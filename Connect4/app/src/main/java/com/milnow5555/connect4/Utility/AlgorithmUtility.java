package com.milnow5555.connect4.Utility;


import android.content.Context;
import android.media.MediaPlayer;

import com.milnow5555.connect4.GameBoard.GameBoard;
import com.milnow5555.connect4.R;

public class AlgorithmUtility {

    private static MediaPlayer mediaPlayer;
    public static int checkIfSomeoneWonAndReturnWinner(GameBoard gameBoard,int x,int y, int actualPlayer) {
        return gameBoard.checkIfSomeoneWonAndReturnWinner(x,y,actualPlayer);
    }
    public static boolean canPlaceHere(GameBoard gameBoard, int x, int y){
        return gameBoard.canBePlaced(x,y);
    }
    public static boolean isOccupied(GameBoard gameBoard,int x, int y){
        return gameBoard.isOccupied(x,y);
    }
    public static boolean mapIsFull(GameBoard gameBoard){
        return gameBoard.mapIsFull();
    }

    public static void startMediaPlayer(Context context){
        mediaPlayer = MediaPlayer.create(context, R.raw.ring);
        mediaPlayer.start();
    }
    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }
    public static void stopMediaPlayer(){
        mediaPlayer.stop();
    }
}
