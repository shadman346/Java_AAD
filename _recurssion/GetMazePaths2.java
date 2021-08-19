package _recurssion;

public class GetMazePaths2 {
    public static void main(String[]args){
        printMazePath(0,0,2,2,"");
    }

    public static void printMazePath(int rstart, int cstart, int rend, int cend, String ans){
        if(rstart==rend && cstart==cend){
            System.out.println(ans);
            return;
        }

        if(rstart!=rend) {
            printMazePath(rstart + 1, cstart, rend, cend, ans + "v");
        }

        if(cstart!=cend) {
            printMazePath(rstart, cstart + 1, rend, cend, ans + "h");
        }
    }

}
