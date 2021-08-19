package _backtracking;

public class Nqueens {
    // N*N chess board we need place N queens in position such that they cant kill each other
    public static void main(String[]args){
        int[][] chess = new int[4][4];
        printNQueen(chess, "", 0);
    }

    public static void printNQueen(int[][]chess, String ans, int row){
        if(row==chess.length){
            System.out.println(ans);
            return;
        }

        for(int col=0; col<chess[row].length; col++){
            boolean isQueenSafe = isQueenSafeToPlace(chess,col,row);
            if(isQueenSafe) {
                chess[row][col] = 1;
                printNQueen(chess, ans + row + "," + col + "..", row + 1);
                chess[row][col] = 0;
            }
        }
    }

    public static boolean isQueenSafeToPlace(int[][]chess, int col, int row){
        for(int i=row-1; i>=0;i--){
            if(chess[i][col]==1){
                return false;
            }
        }
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--, j--){
            if(chess[i][j]==1){
                return false;
            }
        }
        for(int i=row-1,j=col+1; i>=0 && j<chess[row].length; i++, j++){
            if(chess[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
