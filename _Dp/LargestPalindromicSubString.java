package _Dp;

import java.util.Scanner;

public class LargestPalindromicSubString {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int startIdx=0, endIdx=0;

        for(int d=0;d<n;d++){
            for(int i=0,j=d;j<n;i++,j++){
                if(d==0){
                    dp[i][j]=true;
                }else if(d==1 && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                }else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                }

                if(dp[i][j]){
                    startIdx=i;
                    endIdx=j;
                }

            }
        }

        return s.substring(startIdx,endIdx+1);
    }
}
