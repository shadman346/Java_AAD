package _recurssion;

import java.util.Arrays;

public class FloodFill_bad {
    public static void main(String[]atgs){
         int[][] mage={
                {0,1,0,0,0,0,0},
                {0,1,0,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,0,1,1,0,1,1},
                {1,0,1,1,0,1,1},
                {1,0,0,0,0,0,0},
        };

        floodFill(mage,0,0,5,6,"");
    }

    public static void floodFill(int[][]arr, int rsrc,int csrc, int rdest,int cdest, String ans){
        if(rsrc==rdest && csrc==cdest){
            System.out.println(ans);
            return;
        }


        if(rsrc+1<=rdest && arr[rsrc+1][csrc]!=1) {
            int[][] temp = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
            temp[rsrc+1][csrc]=1;
            floodFill(temp, rsrc + 1, csrc, rdest, cdest, ans + "d");
        }
        if(csrc+1<=cdest && arr[rsrc][csrc+1]!=1) {
            int[][] temp = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
            temp[rsrc][csrc+1]=1;
            floodFill(temp, rsrc, csrc + 1, rdest, cdest, ans + "r");
        }
        if(rsrc-1>=0 && arr[rsrc-1][csrc]!=1) {
            int[][] temp = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
            temp[rsrc-1][csrc]=1;
            floodFill(temp, rsrc - 1, csrc, rdest, cdest, ans + "u");
        }
        if(csrc-1>=0 && arr[rsrc][csrc-1]!=1) {
            int[][] temp = Arrays.stream(arr).map(int[]::clone).toArray(int[][]::new);
            temp[rsrc][csrc-1]=1;
            floodFill(temp, rsrc, csrc - 1, rdest, cdest, ans + "l");
        }


    }

}
