package _recurssion;

public class GraphMazePathWithJump2 {
    public static void main(String[]args){
        printMazePath(0,0,2,2,"");
    }

    public static void printMazePath(int rstart, int cstart, int rend, int cend, String ans){
        if(rstart==rend && cstart==cend){
            System.out.println(ans);
            return;
        }
        int rows = rend-rstart;
        int cols = cend-cstart;

        for(int i=1;i<=rows;i++) {
            printMazePath(rstart + i, cstart, rend, cend, ans + "v"+i);
        }

        for(int i=1;i<=cols;i++) {
            printMazePath(rstart, cstart + i, rend, cend, ans + "h"+i);
        }

        for(int i=1;i<=rows && i<=cols;i++) {
            printMazePath(rstart + i, cstart + i, rend, cend, ans + "d"+i);
        }

    }

}
