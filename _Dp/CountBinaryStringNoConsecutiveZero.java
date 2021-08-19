package _Dp;

import java.util.Scanner;

public class CountBinaryStringNoConsecutiveZero {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int ans = solve(n);
        System.out.println(ans);
    }

    public static int solve(int n){
        int[][] dp= new int[2][n+1];
        dp[0][1]=1;
        dp[1][1]=1;

        for(int j=2;j<=n;j++){
            dp[0][j]=dp[1][j-1];
            dp[1][j]=dp[1][j-1] + dp[0][j-1];
        }

        return dp[1][n] + dp[0][n];
    }

}
