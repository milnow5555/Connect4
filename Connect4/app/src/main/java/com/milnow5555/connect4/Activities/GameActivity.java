package com.milnow5555.connect4.Activities;

import android.content.Intent;
import android.media.Image;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.milnow5555.connect4.GameBoard.GameBoard;
import com.milnow5555.connect4.R;
import com.milnow5555.connect4.Utility.AlgorithmUtility;

public class GameActivity extends AppCompatActivity {

    private final int BLUE_PLAYER = 1;
    private final int RED_PLAYER = 2;
    private int actualPlayerNumber = BLUE_PLAYER;
    private GameBoard gameBoard = new GameBoard();
    private int numberOfTurn = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initializeGameBoard();
        TextView textView = (TextView)findViewById(R.id.turnNumber);
        textView.setText(Integer.toString(numberOfTurn));
    }

    public void insertButton(View view) throws InterruptedException{
        ImageView clickedButton = (ImageView)view;
        int [] buttonPosition = parsePosition(clickedButton);
        int x = buttonPosition[0];
        int y = buttonPosition[1];

        if(AlgorithmUtility.canPlaceHere(gameBoard,x,y)) {
            if (!AlgorithmUtility.isOccupied(gameBoard,x,y)) {
                gameBoard.updatePosition(x, y, actualPlayerNumber);
                changeButtonColorOnBoard(clickedButton);
                int winner = AlgorithmUtility.checkIfSomeoneWonAndReturnWinner(gameBoard,x,y,actualPlayerNumber);
            if(winner != 0){
                changeWinnerPlacesColor(gameBoard.getWinnerBoardArray());
                Intent intent = new Intent(this, EndGameActivity.class);
                String msg;
                if(winner == 1)msg = "BLUE";
                else msg = "RED";
                intent.putExtra("message", "Winner is: " + msg + "!!");
                startActivity(intent);
            }

            if(AlgorithmUtility.mapIsFull(gameBoard)){
                Intent intent = new Intent(this, EndGameActivity.class);
                intent.putExtra("message", "Map is full!!");
                startActivity(intent);
            }
                changePlayerTurnColor();
                changePlayer();
                numberOfTurn++;
                changeNumberTurn();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(), R.string.occupy_toast , Toast.LENGTH_SHORT);
                toast.show();
            }
        }else{
            Toast toast = Toast.makeText(getApplicationContext(), R.string.fill_toast , Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private void changeWinnerPlacesColor(int [][] winnerArray){
        int [] pointArray = new int[8];
        int pointArratIterator = 0;
        for(int i=0;i<winnerArray.length;i++){
            for(int j=0;j<winnerArray[i].length;j++){
                if(winnerArray[i][j] == 3){
                    pointArray[pointArratIterator] = i;
                    pointArratIterator++;
                    pointArray[pointArratIterator] = j;
                    pointArratIterator++;
                }
           }
        }
        ImageView firstButton = getButtonImageView(pointArray[0],pointArray[1]);
        ImageView secondButton = getButtonImageView(pointArray[2],pointArray[3]);
        ImageView thirdButton = getButtonImageView(pointArray[4],pointArray[5]);
        ImageView fourthButton = getButtonImageView(pointArray[6],pointArray[7]);
        firstButton.setImageResource(R.drawable.gold_button);
        secondButton.setImageResource(R.drawable.gold_button);
        thirdButton.setImageResource(R.drawable.gold_button);
        fourthButton.setImageResource(R.drawable.gold_button);
    }
    private void changeButtonColorOnBoard(ImageView clickedButton){
        String blue = "bluebutton";
        if(actualPlayerNumber == BLUE_PLAYER) {
            clickedButton.setImageResource(R.drawable.bluebutton);
        }else clickedButton.setImageResource(R.drawable.red_button);
    }
    private void initializeGameBoard(){
        gameBoard.initializeGameBoard();
    }
    private void changePlayer(){
        if(actualPlayerNumber == BLUE_PLAYER) actualPlayerNumber = RED_PLAYER;
        else actualPlayerNumber = BLUE_PLAYER;
    }

    private void changePlayerTurnColor(){
        ImageView playerTurnColor = (ImageView)findViewById(R.id.playerTurnColor);
        if(actualPlayerNumber == BLUE_PLAYER) {
            playerTurnColor.setImageResource(R.drawable.red_button);
        }else {
            playerTurnColor.setImageResource(R.drawable.bluebutton);
        }
    }
    private void changeNumberTurn(){
        TextView textView = (TextView)findViewById(R.id.turnNumber);
        textView.setText(Integer.toString(numberOfTurn));
    }
    private ImageView getButtonImageView(int x, int y){
        if(x==0 && y==0)return (ImageView)findViewById(R.id.img00);
        else if(x==0 && y==1)return (ImageView)findViewById(R.id.img01);
        else if(x==0 && y==2)return (ImageView)findViewById(R.id.img02);
        else if(x==0 && y==3)return (ImageView)findViewById(R.id.img03);
        else if(x==0 && y==4)return (ImageView)findViewById(R.id.img04);
        else if(x==0 && y==5)return (ImageView)findViewById(R.id.img05);
        else if(x==0 && y==6)return (ImageView)findViewById(R.id.img06);
        else if(x==1 && y==0)return (ImageView)findViewById(R.id.img10);
        else if(x==1 && y==1)return (ImageView)findViewById(R.id.img11);
        else if(x==1 && y==2)return (ImageView)findViewById(R.id.img12);
        else if(x==1 && y==3)return (ImageView)findViewById(R.id.img13);
        else if(x==1 && y==4)return (ImageView)findViewById(R.id.img14);
        else if(x==1 && y==5)return (ImageView)findViewById(R.id.img15);
        else if(x==1 && y==6)return (ImageView)findViewById(R.id.img16);
        else if(x==2 && y==0)return (ImageView)findViewById(R.id.img20);
        else if(x==2 && y==1)return (ImageView)findViewById(R.id.img21);
        else if(x==2 && y==2)return (ImageView)findViewById(R.id.img22);
        else if(x==2 && y==3)return (ImageView)findViewById(R.id.img23);
        else if(x==2 && y==4)return (ImageView)findViewById(R.id.img24);
        else if(x==2 && y==5)return (ImageView)findViewById(R.id.img25);
        else if(x==2 && y==6)return (ImageView)findViewById(R.id.img26);
        else if(x==3 && y==0)return (ImageView)findViewById(R.id.img30);
        else if(x==3 && y==1)return (ImageView)findViewById(R.id.img31);
        else if(x==3 && y==2)return (ImageView)findViewById(R.id.img32);
        else if(x==3 && y==3)return (ImageView)findViewById(R.id.img33);
        else if(x==3 && y==4)return (ImageView)findViewById(R.id.img34);
        else if(x==3 && y==5)return (ImageView)findViewById(R.id.img35);
        else if(x==3 && y==6)return (ImageView)findViewById(R.id.img36);
        else if(x==4 && y==0)return (ImageView)findViewById(R.id.img40);
        else if(x==4 && y==1)return (ImageView)findViewById(R.id.img41);
        else if(x==4 && y==2)return (ImageView)findViewById(R.id.img42);
        else if(x==4 && y==3)return (ImageView)findViewById(R.id.img43);
        else if(x==4 && y==4)return (ImageView)findViewById(R.id.img44);
        else if(x==4 && y==5)return (ImageView)findViewById(R.id.img45);
        else if(x==4 && y==6)return (ImageView)findViewById(R.id.img46);
        else if(x==5 && y==0)return (ImageView)findViewById(R.id.img50);
        else if(x==5 && y==1)return (ImageView)findViewById(R.id.img51);
        else if(x==5 && y==2)return (ImageView)findViewById(R.id.img52);
        else if(x==5 && y==3)return (ImageView)findViewById(R.id.img53);
        else if(x==5 && y==4)return (ImageView)findViewById(R.id.img54);
        else if(x==5 && y==5)return (ImageView)findViewById(R.id.img55);
        else return (ImageView)findViewById(R.id.img56);


    }
    private int[] parsePosition(ImageView clickedButton) {
        int [] arrayHelper = new int[2];
        if(clickedButton == (ImageView)findViewById(R.id.img00) ){
            arrayHelper[0] = 0;
            arrayHelper[1] = 0;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img01)){
            arrayHelper[0] = 0;
            arrayHelper[1] = 1;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img02)) {
            arrayHelper[0] = 0;
            arrayHelper[1] = 2;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img03)){
            arrayHelper[0] = 0;
            arrayHelper[1] = 3;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img04)){
            arrayHelper[0] = 0;
            arrayHelper[1] = 4;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img05)) {
            arrayHelper[0] = 0;
            arrayHelper[1] = 5;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img06)){
            arrayHelper[0] = 0;
            arrayHelper[1] = 6;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img10)){
            arrayHelper[0] = 1;
            arrayHelper[1] = 0;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img11)) {
            arrayHelper[0] = 1;
            arrayHelper[1] = 1;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img12)){
            arrayHelper[0] = 1;
            arrayHelper[1] = 2;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img13)){
            arrayHelper[0] = 1;
            arrayHelper[1] = 3;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img14)) {
            arrayHelper[0] = 1;
            arrayHelper[1] = 4;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img15)){
            arrayHelper[0] = 1;
            arrayHelper[1] = 5;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img16)){
            arrayHelper[0] = 1;
            arrayHelper[1] = 6;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img20)) {
            arrayHelper[0] = 2;
            arrayHelper[1] = 0;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img21)){
            arrayHelper[0] = 2;
            arrayHelper[1] = 1;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img22)){
            arrayHelper[0] = 2;
            arrayHelper[1] = 2;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img23)) {
            arrayHelper[0] = 2;
            arrayHelper[1] = 3;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img24)){
            arrayHelper[0] = 2;
            arrayHelper[1] = 4;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img25)){
            arrayHelper[0] = 2;
            arrayHelper[1] = 5;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img26)) {
            arrayHelper[0] = 2;
            arrayHelper[1] = 6;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img30)){
            arrayHelper[0] = 3;
            arrayHelper[1] = 0;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img31)){
            arrayHelper[0] = 3;
            arrayHelper[1] = 1;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img32)) {
            arrayHelper[0] = 3;
            arrayHelper[1] = 2;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img33)){
            arrayHelper[0] = 3;
            arrayHelper[1] = 3;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img34)){
            arrayHelper[0] = 3;
            arrayHelper[1] = 4;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img35)) {
            arrayHelper[0] = 3;
            arrayHelper[1] = 5;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img36)){
            arrayHelper[0] = 3;
            arrayHelper[1] = 6;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img40)){
            arrayHelper[0] = 4;
            arrayHelper[1] = 0;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img41)) {
            arrayHelper[0] = 4;
            arrayHelper[1] = 1;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img42)){
            arrayHelper[0] = 4;
            arrayHelper[1] = 2;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img43)){
            arrayHelper[0] = 4;
            arrayHelper[1] = 3;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img44)) {
            arrayHelper[0] = 4;
            arrayHelper[1] = 4;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img45)){
            arrayHelper[0] = 4;
            arrayHelper[1] = 5;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img46)){
            arrayHelper[0] = 4;
            arrayHelper[1] = 6;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img50)) {
            arrayHelper[0] = 5;
            arrayHelper[1] = 0;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img51)){
            arrayHelper[0] = 5;
            arrayHelper[1] = 1;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img52)){
            arrayHelper[0] = 5;
            arrayHelper[1] = 2;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img53)) {
            arrayHelper[0] = 5;
            arrayHelper[1] = 3;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img54)){
            arrayHelper[0] = 5;
            arrayHelper[1] = 4;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img55)){
            arrayHelper[0] = 5;
            arrayHelper[1] = 5;
            return arrayHelper;
        }else if(clickedButton == (ImageView)findViewById(R.id.img56)) {
            arrayHelper[0] = 5;
            arrayHelper[1] = 6;
            return arrayHelper;
        }else {
            return arrayHelper;
        }

    }
    public void reset(View view) {
        gameBoard.initializeGameBoard();
        for(int line[]:gameBoard.getGameBoardArray()){
            for(int cell:line){
                Log.i("RESETED","R" + cell);
            }
        }

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                getButtonImageView(i, j).setImageResource(R.drawable.free4all0);
            }
        }
        numberOfTurn=0;
        actualPlayerNumber = BLUE_PLAYER;
        ImageView viewById = (ImageView) findViewById(R.id.playerTurnColor);
        viewById.setImageResource(R.drawable.bluebutton);
        TextView textView = (TextView)findViewById(R.id.turnNumber);
        textView.setText(Integer.toString(numberOfTurn));
    }
}
