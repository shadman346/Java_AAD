package _Dp;

import java.util.Scanner;

public class CountPalindromicSubStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int ans = countSubstrings(str);
        System.out.println(ans);
    }

    public static int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans=0;
        for(int d=0;d<n;d++){
            for(int i=0,j=d;j<n;i++,j++){
                if(d==0){
                    dp[i][j]=true;
                }else if(d==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                }else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                }

                if(dp[i][j])
                    ans++;
            }
        }

        return ans;
    }
}
