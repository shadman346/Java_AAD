package _Dp;

import java.util.Scanner;

public class CountOfSubSetSum {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i]=scn.nextInt();
        }
        int sum = scn.nextInt();
        int count = solve(arr,n,sum);
        System.out.println(count);
    }

    public static int solve(int[]arr,int n, int sum){
        int[][]dp=new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=sum; j++){

                if(arr[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else{
                    int t = dp[i-1][j-arr[i-1]];
                    dp[i][j]= t + dp[i-1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
