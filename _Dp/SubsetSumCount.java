package _Dp;

public class SubsetSumCount {
    public static void main(String[] args) {
        int[]arr = {2,5,6,7,3,1,4};
        int size = arr.length;
        int target = 6;

        int[][]dp=new int[100][100];
        for(int i=0;i<size+1;i++){
            dp[i][0]=1;
        }
        subsetSumCount(arr,target,dp);

    }

    public static void subsetSumCount(int[]arr,int t, int[][]dp){
        for(int i=1;i<=arr.length ; i++){
            for (int j=1; j<=t; j++){
                if(arr[i-1]>j){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]= dp[i-1][j-arr[i-1]] + dp[i-1][j] ;
                }
            }
        }
        System.out.println(dp[arr.length][t]);
    }
}
