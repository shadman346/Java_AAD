package _Dp;

import java.util.Scanner;

public class MaximumSumNonAdjacentElements {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n;i++)
            arr[i]=scn.nextInt();

        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        int include=0,exclude=0;
        for(int i=0;i< arr.length; i++){
            int temp = include;   // old value of include
            include = exclude + arr[i];     // new value of include using old value of exclude
            exclude = Math.max(temp,exclude);    //required old value of include to find new value of exclude;
        }

        return Math.max(include, exclude);
    }
}
