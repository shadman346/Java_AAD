package _iterative;

import java.util.*;

public class PermutationOfStrings {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        printPermutation(str);
    }
    private static void printPermutation(String str) {
        int l = str.length();
        int permutationCount = giveTotalPermutation(l);
        for(int i=0; i<permutationCount; i++){
            int ques = i, remainder;
            StringBuilder strReduce = new StringBuilder(str);
            StringBuilder strPermutated = new StringBuilder();
            for(int k=l;k>=1;k--){
                remainder = ques%k;
                ques = ques/k;
                strPermutated.append(strReduce.charAt(remainder));
                strReduce.deleteCharAt(remainder);
            }
            System.out.println(strPermutated);
        }
    }

    private static int giveTotalPermutation(int length) {
        int count=1;
        for(int i=2;i<=length;i++){
            count*=i;
        }
        return count;
    }
}
