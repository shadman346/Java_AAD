package _recurssionAndBacktracking2;

import java.util.Scanner;

public class NqueensBranchBound {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        //write your code here
        boolean[] cols = new boolean[n];
        boolean[] ndiag = new boolean[2*n-1];
        boolean[] rdiag = new boolean[2*n-1];
        nQueen(board,0,"",cols,ndiag,rdiag);

    }
    static void nQueen(boolean[][]board,int row,String psf,boolean[]cols,boolean[]ndiag,boolean[]rdiag){
        if(row==board.length){
            System.out.println(psf+".");
            return;
        }
        
        for(int col=0; col<board.length; col++){
            if(isValid(board.length,row,col,cols,ndiag,rdiag)){
                cols[col]=true;
                ndiag[row+col]=true;
                int revDiag = row-col+board.length-1;
                rdiag[revDiag]=true;
                nQueen(board,row+1,psf+row+"-"+col+",",cols,ndiag,rdiag);
                cols[col]=false;
                ndiag[row+col]=false;
                rdiag[revDiag]=false;
            }
        }
    }
    static boolean isValid(int size,int r, int c,boolean[]cols,boolean[]ndiag,boolean[]rdiag){
        if(cols[c])
            return false;

        if(ndiag[r+c])
            return false;

        int revDiag = r-c+size-1;
        if(rdiag[revDiag])
            return false;

        return true;
    }
}
