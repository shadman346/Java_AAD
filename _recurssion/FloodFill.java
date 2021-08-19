package _recurssion;

public class FloodFill {
    public static void main(String[]atgs){
        int[][] mage={
                {0,1,0,0,0,0,0},
                {0,1,0,1,1,1,0},
                {0,0,0,0,0,0,0},
                {1,0,1,1,0,1,1},
                {1,0,1,1,0,1,1},
                {1,0,0,0,0,0,0},
        };

        floodFill(mage,0,0,5,6,"",isVisited);
    }
    static boolean[][] isVisited = new boolean[6][7];

    //source ----> destination
    public static void floodFill(int[][] arr, int rsrc,int csrc, int rdest,int cdest, String ans , boolean[][] isVisited){
        if(rsrc<0 || csrc<0 || rsrc>rdest || csrc>cdest || arr[rsrc][csrc]==1 || isVisited[rsrc][csrc]==true){
            return;
        }

        if(rsrc==rdest && csrc==cdest){
            System.out.println(ans);
            return;
        }

        isVisited[rsrc][csrc] = true;
        floodFill(arr, rsrc-1, csrc, rdest, cdest, ans+"t", isVisited);
        floodFill(arr, rsrc, csrc-1, rdest, cdest, ans+"l", isVisited);
        floodFill(arr, rsrc+1, csrc, rdest, cdest, ans+"d", isVisited);
        floodFill(arr, rsrc, csrc+1, rdest, cdest, ans+"r", isVisited);
        isVisited[rsrc][csrc] = false;
    }
}
