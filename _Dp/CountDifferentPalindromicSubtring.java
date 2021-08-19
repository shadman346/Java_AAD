package _Dp;

import java.util.HashSet;

public class CountDifferentPalindromicSubtring {
    public static void main(String[] args) {
        CountDifferentPalindromicSubtring x = new CountDifferentPalindromicSubtring();
        int ans =x.countPalindromicSubsequences("bcb");
        System.out.println(ans);
    }

     private static class cell{
        int length;
        StringBuilder sub;
        cell(){
            sub = new StringBuilder();
        }

        static cell compare(cell d1, cell d2){
            if(d1.length>=d2.length)
                return d1;
            else{
                return d2;
            }
        }

    }
      int countPalindromicSubsequences(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int n = s.length();
        cell[][]dp = new cell[n+1][n+1];
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<=n;i++){
            if(i>=1) set.add(s.charAt(i-1)+"");
            for(int j=0;j<=n;j++){
                dp[i][j]= new cell();
                if(i==0 || j==0){
                    dp[i][j].length=0;
                }
                else if(s2.charAt(i-1)==s.charAt(j-1)) {
                    dp[i][j].length = 1 + dp[i - 1][j - 1].length;
                    dp[i][j].sub.append(dp[i - 1][j - 1].sub).append(s2.charAt(i - 1));
                        set.add(dp[i][j].sub.toString());
                }
                else{
                    cell t = cell.compare(dp[i-1][j],dp[i][j-1]);
                    dp[i][j].length= t.length;
                    dp[i][j].sub.append(t.sub);
                }
            }
        }


        return set.size()%1000000007;
    }
}
