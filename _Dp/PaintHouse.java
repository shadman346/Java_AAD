package _Dp;

public class PaintHouse {
    public static void main(String[] args) {
        int[][] arr = {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(arr));
    }

    public static int minCost(int[][] costs) {
        // int[][] dp = new int[3][costs.length];
        // dp[0][0]=costs[0][0];
        // dp[1][0]=costs[0][1];
        // dp[2][0]=costs[0][2];
        // int j=0;
        // for(j=1;j<costs.length;j++){
        //         dp[0][j] =Math.min(dp[1][j-1],dp[2][j-1]) + costs[j][0];
        //         dp[1][j] =Math.min(dp[0][j-1],dp[2][j-1]) + costs[j][1];
        //         dp[2][j] =Math.min(dp[0][j-1],dp[1][j-1]) + costs[j][2];
        // }
        // j--;
        // return Math.min(dp[0][j],Math.min(dp[1][j],dp[2][j]));

        int red=costs[0][0];
        int green=costs[0][1];
        int blue=costs[0][2];

        for(int i=1;i<costs.length;i++){
            int r=red, g=green, b=blue;
            red = Math.min(g,b) + costs[i][0];
            green = Math.min(r,b) + costs[i][1];
            blue = Math.min(g,r) + costs[i][2];
        }
        return Math.min(red,Math.min(green,blue));

    }
}
