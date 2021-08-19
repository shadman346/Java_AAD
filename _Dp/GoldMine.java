package _Dp;

import java.util.Arrays;
import java.util.Scanner;

public class GoldMine {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][]arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=scn.nextInt();
            }
        }

        int max = solve(arr,n,m);
        System.out.println(max);
    }

    public static int solve(int[][]arr,int n,int m){
        int[][]dp= new int[n][m];

        for(int j=m-1;j>=0;j--){
            for(int i=n-1;i>=0;i--){
                if(j==m-1){
                    dp[i][j]=arr[i][j];
                }else if(i==0){
                    dp[i][j] = arr[i][j]+ Math.max(dp[i][j+1],dp[i+1][j+1]);
                }else if(i==n-1){
                    dp[i][j] = arr[i][j]+ Math.max(dp[i][j+1],dp[i-1][j+1]);
                }else{
                    dp[i][j] = arr[i][j]+ Math.max(dp[i][j+1],Math.max(dp[i+1][j+1],dp[i-1][j+1]));
                }
            }
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,dp[i][0]);
        }

        return ans;
    }
}
