package _Searching_Sorting;

import java.util.Scanner;

public class MaximizeTheOutput1 {
    // you have given an array and you need to maximize summation(i*arr[i])
    // given you can only rotate array elements
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr =new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        foo(arr,n);
    }

    private static void foo(int[] arr, int n) {
        // maximize summation arr[i]*i
        // S0= 0*a+1*b+2*c+3*d+4*e;   // 0 rotation or rotate%n==0
        // S1 = 0e+1a+2b+3c+4d  // after 1 effective rotation
        // we can build a relation of current rotation by 1 from prev rotation.
        //  S1 =    (0a+1b+2c+3d+4e) + (a+b+c+d+e)  - 5e
        // Scurr      S0 or Sprev          sum      5*arr[5-1]
        //Si = Si-1 + sum - n*arr[n-i]; (when S!=0)

        int sum=0, Sprev=0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
            Sprev+=i*arr[i]; // calculating S0
        }
        int maxSummation =Sprev;
        int Scurr;
        for (int i = 1; i < n; i++) {       //n-1 rotation possible
            Scurr = Sprev + sum - n*arr[n-i];
            maxSummation=Math.max(maxSummation,Scurr);
            Sprev = Scurr;
        }

        System.out.println(maxSummation);
    }

}
