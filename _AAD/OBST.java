package _AAD;

public class OBST {
    public static void optimalBST(int[]key,int[]frequency,int n){
        int[][] dp = new int[n][n];

        int[] psa = new int[n];
        psa[0]=frequency[0];
        for(int i=1; i<n;i++){
            psa[i]= psa[i-1] + frequency[i];
        }

        for (int g=0; g<dp.length;g++){
            for(int i=0,j=g;j<n; i++,j++){
                if(g==0){
                    dp[i][j]=frequency[i];
                }else if(g==1){
                    int f1=frequency[i];
                    int f2=frequency[j];
                    dp[i][j]=Math.min(f1 + 2*f2, f2 + 2*f1);
                }else{
                    int min = Integer.MAX_VALUE;
                    int fs = psa[j] - (i==0?0: psa[i-1]);

                    for(int k=i; k<=j; k++){
                        int left = k==0?0: dp[i][k-1];
                        int right = k==j?0: dp[k+1][j];

                        if(left + right + fs < min){
                            min = left + right + fs;
                        }
                    }
                    dp[i][j]=min;
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
    public static void main(String[] args) {
        int[] keys = {11,22,33,44,55};
        int[] frequency = {3,6,4,3,8,};

        optimalBST(keys,frequency,keys.length);
    }
}
