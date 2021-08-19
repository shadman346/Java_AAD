package _Searching_Sorting;

import java.util.Scanner;

public class SearchInSorted2DMatrix {
    public static boolean search(int[][]matrix,int target) {
        //write your code here
        int lo =0,hi=matrix.length-1;
        int size = matrix[0].length;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            int l = matrix[mid][0];
            int r = matrix[mid][size-1];
            if(target<l){
                hi = mid-1;
            }else if(target>r){
                lo = mid+1;
            }else{
                int n=mid;
                lo = 0;
                hi = size-1;
                while(lo<=hi){
                    mid = (lo+hi)/2;
                    int val =matrix[n][mid];
                    if(val==target) {
                        return true;
                    }else if(target<val){
                        hi = mid-1;
                    }else if(target>val){
                        lo=mid+1;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[]args) {
        //input work
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();

        int[][]matrix = new int[m][n];

        for(int i=0; i < m;i++) {
            for(int j=0; j < n;j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        int target = scn.nextInt();

        boolean isFound = search(matrix,target);
        System.out.println(isFound);

    }
}
