package _Dp;

import java.util.Scanner;

public class KPartitionIntoSubset {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int people = scn.nextInt();
        int groups = scn.nextInt();
        System.out.println(solve(people,groups));
    }

    public static int solve(int n, int k){
        int[][]dp = new int[k+1][n+1];
        for(int j=1;j<=n;j++){
            dp[1][j]=1;
        }

        for(int i=2; i<=k; i++){
            for(int j=i; j<=n; j++){
                dp[i][j]= i*dp[i][j-1] + dp[i-1][j-1];
            }
        }

        return dp[k][n];
    }
}
