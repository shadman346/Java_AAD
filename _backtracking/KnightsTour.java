package _backtracking;

public class KnightsTour {
    public static void main(String[] args) {
        int n=5;
        int[][] chess = new int[5][5];
        printKnightTours(chess,"",2,2); //start position
    }
    static int move =0;
    public static void printKnightTours(int[][] chess,String ans, int row, int col){
        if(move==chess.length* chess.length){
            System.out.println(ans);
            return;
        }
        if(row<0 || col<0 || row>=chess.length || col>=chess[row].length || chess[row][col] > 0){
            return;
        }

        move++;
        chess[row][col] = move;

        printKnightTours(chess,ans + row + "," + col + "..",row-2,col+1);

        printKnightTours(chess,ans + row + "," + col + "..",row-1,col+2);

        printKnightTours(chess,ans + row + "," + col + "..",row+1,col+2);

        printKnightTours(chess,ans + row + "," + col + "..",row+2,col+1);

        printKnightTours(chess,ans + row + "," + col + "..",row+2,col-1);

        printKnightTours(chess,ans + row + "," + col + "..",row+1,col-2);

        printKnightTours(chess,ans + row + "," + col + "..",row-1,col-2);

        printKnightTours(chess,ans + row + "," + col + "..",row-2,col-1);

        chess[row][col]=0;

        move--;
    }
}
