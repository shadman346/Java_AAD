package _Dp;

import java.util.HashMap;
import java.util.Scanner;

public class CountA_b_c_Subsequences {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        m.put('a',1);
        m.put('b',2);
        m.put('c',3);
        System.out.println(count(str));
    }
    static HashMap<Character,Integer> m = new HashMap<>();


    public static int count(String s){
        int[][]dp = new int[4][s.length()+1];

        for(int j=1;j<=s.length();j++){
            char ch = s.charAt(j-1);
            int v = m.get(ch);
            for(int i=1; i<4; i++){
                if(v==i && i==1)
                    dp[i][j]= 2*dp[i][j-1] + 1 +dp[i-1][j-1];
                else if (v==i)
                    dp[i][j]= 2*dp[i][j-1] +dp[i-1][j-1];
                else
                    dp[i][j]=dp[i][j-1];
            }
        }
        return dp[3][s.length()];
    }


}
