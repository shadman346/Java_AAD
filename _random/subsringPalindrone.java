package _random;

public class subsringPalindrone {
    public static void main(String[] args) {
        String str = "aacabdkacaak";
        Solution obj = new Solution();
        String x = obj.longestPalindrome(str);
        System.out.println(x);

    }
    static class Solution {
        public String longestPalindrome(String s) {
            int[][] dp = new int[s.length()+1][s.length()+1];
            for (int i=0; i<=s.length(); i++){
                dp[0][i]=0;
                dp[i][s.length()]=0;
            }

            int ans = -1;
            for(int i=1;i<=s.length();i++){
                for(int j=s.length()-1; j>=0; j--){
                    if(s.charAt(i-1)==s.charAt(j)){
                        dp[i][j]= 1 + dp[i-1][j+1];
                        ans = Math.max(dp[i][j],ans);
                    }

                    else{
                        dp[i][j]=0;
                    }
                }
            }
            String str="";
            for(int i=1;i<=s.length();i++){
                for(int j=s.length()-1; j>=0; j--){
                    if(dp[i][j]==ans){
                        while(dp[i][j]!=0){
                            str+=s.charAt(i-1);
                            i--;
                            j++;
                        }
                        return str;
                    }
                }
            }
          return str;

        }
    }
}
