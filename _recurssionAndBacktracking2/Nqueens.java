package _recurssionAndBacktracking2;

import java.util.Scanner;

public class Nqueens {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        //write your code here
        nQueen(board,0,"");

    }
    static void nQueen(boolean[][]board,int row,String psf){
        if(row==board.length){
            System.out.println(psf+".");
            return;
        }
        for(int j=0; j<board.length; j++){
            if(isValid(board,row,j)){
                board[row][j]=true;
                nQueen(board,row+1,psf+row+"-"+j+",");
                board[row][j]=false;
            }
        }
    }
    static boolean isValid(boolean[][] board , int r, int c){
        for(int i=r-1,j=c-1; i>=0 && j>=0;i--,j--){
            if(board[i][j]==true){
                return false;
            }
        }

        for(int i=r-1,j=c+1; i>=0 && j<board.length;i--,j++){
            if(board[i][j]==true){
                return false;
            }
        }

        for(int i=r-1; i>=0;i--){
            if(board[i][c]==true){
                return false;
            }
        }

        return true;
    }
}
