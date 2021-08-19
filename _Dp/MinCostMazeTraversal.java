package _Dp;

import java.util.Scanner;

public class MinCostMazeTraversal {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        int cost = solve(arr,n,m);
        System.out.println(cost);
    }

    public static int solve(int[][]arr,int n,int m){
        int[][]dp = new int[n][m];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1; j>=0; j--){
                if(i==n-1 && j==m-1){
                    dp[i][j]=arr[i][j];
                    continue;
                }
                int hrz=Integer.MAX_VALUE;
                int vt=Integer.MAX_VALUE;
                if(j<m-1)
                    hrz = dp[i][j+1];
                if(i<n-1)
                    vt = dp[i+1][j];

                dp[i][j] = Math.min(hrz,vt) + arr[i][j];
            }
        }

        return dp[0][0];
    }
}
