package _Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MakingLargestIsland {
    public static void main(String[] args) {
        int[][]arr ={{0,0},{0,0}};
        System.out.println(largestIsland(arr));
    }
    public static int largestIsland(int[][] grid) {

        HashMap<Integer,Integer> islands=new HashMap<>();
        islands.put(0,0);
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]>1 || grid[i][j]==0) continue;

                int x = (i+1)*500 + j;
                int l = move(grid,i,j,x);
                islands.put(x,l);
            }
        }
        if(islands.containsKey(500) && islands.get(500)==grid.length*grid.length) return grid.length*grid.length;
        int l= 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]>0) continue;
                int sum=1;
                HashMap<Integer,Integer> list =new HashMap<>();
                if(i>0 ) list.put(grid[i-1][j],islands.get(grid[i-1][j]));
                if(i<grid.length-1 ) list.put(grid[i+1][j],islands.get(grid[i+1][j]));
                if(j>0 ) list.put(grid[i][j-1],islands.get(grid[i][j-1]));
                if(j<grid.length-1 ) list.put(grid[i][j+1],islands.get(grid[i][j+1]));

                for (Map.Entry mapElement : list.entrySet()) {
                    sum = ((int)mapElement.getValue() + sum);
                }
                l = Math.max(l,sum);

            }
        }

        return l;
    }

    public static int move(int[][]arr,int i, int j, int x ){

        if(i==arr.length || j==arr.length || i<0 || j<0 || arr[i][j]==0 || arr[i][j]==x)
            return 0;

        arr[i][j]=x;
        int u =move(arr,i-1,j,x);
        int d =move(arr,i+1,j,x);
        int l =move(arr,i,j-1,x);
        int r =move(arr,i,j+1,x);


        return u+d+l+r+1;

    }
}
