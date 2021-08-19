package _Dp;
import java.util.*;
public class CoinChangeCombination {
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
        int[] dp = new int[sum+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=1;j<=sum;j++){
                if(arr[i]<=j){
                    dp[j]= dp[j-arr[i]] + dp[j];
                }
            }
        }

        return dp[sum];
    }
}
