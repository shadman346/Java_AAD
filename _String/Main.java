package _String;

import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args){
//        permutation("abc");
        String s = "cba";
        System.out.println(s.length());
        char[] c = s.toCharArray();
        Arrays.sort(c);
        System.out.println(new String(c));

    }
    public static int factorial(int x){
        int rs=1;
        for(int i=1;i<=x;i++){
            rs= rs*i;
        }
        return rs;
    }

    public static void permutation(String str){
        int n = str.length();
        int f = factorial(n);

        for (int i=0; i<f ; i++){
            int temp= i;
            StringBuilder sb = new StringBuilder(str);
            for(int div=n; div>=1;div--){
                int q = temp/div;
                int r = temp%div;
                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
                temp=q;
            }
            System.out.println();
        }
    }


}
