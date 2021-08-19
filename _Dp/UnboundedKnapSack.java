package _Dp;

import java.util.Scanner;

public class UnboundedKnapSack {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] val= new int[n];
        for(int i=0;i<n;i++){
            val[i]=scn.nextInt();
        }
        int[] wt= new int[n];
        for(int i=0;i<n;i++){
            wt[i]=scn.nextInt();
        }
        int capacity = scn.nextInt();
        int count = solve(wt,val,n,capacity);
        System.out.println(count);
    }

    public static int solve(int[]wt,int[]val,int n,int cap){
        int[] dp = new int[cap+1];

        for(int i=0;i<n;i++){
            for(int j=1;j<=cap;j++){
                if(wt[i]<=j){
                    dp[j]=Math.max(dp[j-wt[i]]+val[i],dp[j]);
                }
            }
        }

        return dp[cap];
    }
}
