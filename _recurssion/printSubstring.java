package _recurssion;

import java.util.Scanner;

public class printSubstring {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solve(str,0,"");

    }

    private static void solve(String str, int i, String prnt) {
        if(i==str.length()){
            if(prnt.length()>0)
                System.out.println(prnt);
            return;
        }
        char ch = str.charAt(i);
        solve(str,i+1, prnt+ch);
        solve(str,i+1,"");
    }
}
