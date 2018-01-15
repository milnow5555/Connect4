package com.milnow5555.connect4.GameBoard;


import android.util.Log;

public class GameBoard {
    private int[][] gameBoardArray = new int[6][7];
    private int[][] winnerBoardArray = new int[6][7];
    private int actualPlayer;
    private final int WINNER_NUMBER = 3;
    public void initializeGameBoard() {
        for(int i=0;i<gameBoardArray.length;i++){
            for(int j=0;j<gameBoardArray[i].length;j++){
                gameBoardArray[i][j]=0;
            }
        }
    }
    public void updatePosition(int x, int y,int actualPlayerNumber){
        gameBoardArray[x][y] = actualPlayerNumber;
    }
    public boolean isOccupied(int x, int y){
        if(gameBoardArray[x][y] != 0) return true;
        else return false;
    }
    public boolean mapIsFull(){
        boolean returnValue = true;
        for(int line[]:gameBoardArray){
            for(int cell:line){
                if(cell == 0) returnValue = false;
            }
        }
        return returnValue;
    }
    public boolean canBePlaced(int x, int y){
        if(x == 5 || gameBoardArray[x+1][y]!=0)return true;
        else return false;
    }
    public int checkIfSomeoneWonAndReturnWinner(int x, int y, int actualPlayer){
        resetWinnerArray();
        this.actualPlayer = actualPlayer;

        if(checkRightCrossLine(x,y) >= 3) return actualPlayer;
        resetWinnerArray();
        if(checkLeftCrossLine(x,y) >= 3) return actualPlayer;
        resetWinnerArray();
        if(checkHorizontalLine(x,y) >= 3) return actualPlayer;
        resetWinnerArray();
        if(checkBottomLine(x,y) == 3) return actualPlayer;
        resetWinnerArray();

        return 0;
    }
    private void resetWinnerArray(){
        for(int i=0;i<winnerBoardArray.length;i++){
            for(int j=0;j<winnerBoardArray[i].length;j++){
                winnerBoardArray[i][j] = gameBoardArray[i][j];
            }
        }
    }

    public int[][] getWinnerBoardArray() {
        return winnerBoardArray;
    }

    private int checkRightCrossLine(int x, int y){
        int counter=0;
        int iteratorCounter=1;
        winnerBoardArray[x][y] = WINNER_NUMBER;
        while(iteratorCounter<4){
            if(x-iteratorCounter<0 || y+iteratorCounter>6 || winnerBoardArray[x-iteratorCounter][y+iteratorCounter]!=actualPlayer){
                int k = x - iteratorCounter;
                int b = y + iteratorCounter;
                Log.i("k1","k1 " + k);
                Log.i("b1","b1 " + b);
                break;
            }
            if(winnerBoardArray[x-iteratorCounter][y+iteratorCounter]==actualPlayer){
                winnerBoardArray[x-iteratorCounter][y+iteratorCounter] = WINNER_NUMBER;
                counter++;
            }
            iteratorCounter++;
        }
        iteratorCounter = 1;
        while(iteratorCounter<4){
            if(x+iteratorCounter>5 || y-iteratorCounter<0 || winnerBoardArray[x+iteratorCounter][y-iteratorCounter]!=actualPlayer){
                int k = x + iteratorCounter;
                int b = y - iteratorCounter;
                Log.i("k2","k2 " + k);
                Log.i("b2","b2 " + b);
                break;
            }
            if(winnerBoardArray[x+iteratorCounter][y-iteratorCounter]==actualPlayer){
                winnerBoardArray[x+iteratorCounter][y-iteratorCounter] = WINNER_NUMBER;
                counter++;
            }
            iteratorCounter++;
        }
        Log.i("counter","counter " + counter);
        return counter;
    }
    private int checkLeftCrossLine(int x, int y){
        int counter=0;
        int iteratorCounter=1;
        winnerBoardArray[x][y] = WINNER_NUMBER;
        while(iteratorCounter<4){
            if(x-iteratorCounter<0 || y-iteratorCounter<0 || winnerBoardArray[x-iteratorCounter][y-iteratorCounter]!=actualPlayer)break;
            if(winnerBoardArray[x-iteratorCounter][y-iteratorCounter]==actualPlayer){
                winnerBoardArray[x-iteratorCounter][y-iteratorCounter] = WINNER_NUMBER;
                counter++;
            }
            iteratorCounter++;
        }
        iteratorCounter = 1;
        while(iteratorCounter<4){
            if(x+iteratorCounter>5 || y+iteratorCounter>6 || winnerBoardArray[x+iteratorCounter][y+iteratorCounter]!=actualPlayer)break;
            if(winnerBoardArray[x+iteratorCounter][y+iteratorCounter]==actualPlayer){
                winnerBoardArray[x+iteratorCounter][y+iteratorCounter] = WINNER_NUMBER;
                counter++;
            }
            iteratorCounter++;
        }

        return counter;
    }
    private int checkHorizontalLine(int x, int y){
        int counter=0;
        int iteratorCounter=1;
        winnerBoardArray[x][y] = WINNER_NUMBER;
        while(iteratorCounter<4){
            if(y+iteratorCounter>6 || winnerBoardArray[x][y+iteratorCounter]!=actualPlayer){
                break;
            }
            if(winnerBoardArray[x][y+iteratorCounter]==actualPlayer){
                winnerBoardArray[x][y+iteratorCounter] = WINNER_NUMBER;
                counter++;
            }
            iteratorCounter++;
        }
        iteratorCounter = 1;
        while(iteratorCounter<4){
            if(y-iteratorCounter<0 || winnerBoardArray[x][y-iteratorCounter]!=actualPlayer){
                break;
            }
            if(winnerBoardArray[x][y-iteratorCounter]==actualPlayer){
                winnerBoardArray[x][y-iteratorCounter] = WINNER_NUMBER;
                counter++;
            }
            iteratorCounter++;
        }

        return counter;
    }
    private int checkBottomLine(int x, int y) {
        int counter=0;
        int iteratorCounter=1;
        winnerBoardArray[x][y] = WINNER_NUMBER;
        while(iteratorCounter<4){
            if(x+iteratorCounter>5 || winnerBoardArray[x+iteratorCounter][y]!=actualPlayer)break;
            if(winnerBoardArray[x+iteratorCounter][y]==actualPlayer){
                winnerBoardArray[x+iteratorCounter][y] = WINNER_NUMBER;
                counter++;
            }
            iteratorCounter++;
        }
        return counter;
    }

    public int[][] getGameBoardArray() {
        return gameBoardArray;
    }
}
