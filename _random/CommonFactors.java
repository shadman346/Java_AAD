package _random;

import java.util.Scanner;

public class CommonFactors {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int x = (a < b) ? a : b;
        int ans =1;
        for(int i=2;i*i<=x;i++){
            while(x%i==0){
                x=x/i;
                if(b%i==0){
                    b=b/i;
                    ans++;
                }
            }
        }
        if(x!=1){
            if(b%x==0){
                ans++;
            }
        }
        System.out.println(ans);
    }

}
