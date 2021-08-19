package _2dArray;

import java.util.Scanner;

public class spiralPrint {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] arr= {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        System.out.println("choose shell: ");
        int shell = scn.nextInt();
        System.out.println("how much rotate?: ");
        int rotate = scn.nextInt();

        rotateShell(arr,shell,rotate);
        display(arr);
    }

    public static void rotateShell(int[][] arr, int s, int r){
        int[] oned = fillOnedFromShell(arr,s);
        rotate(oned,r);
        fillShellFromOned(arr,s,oned);
    }

    public static void rotate(int[] arr, int r){
        int rf = r % arr.length;
        if(rf<0) {
            rf+=arr.length;
        }
        reverse(arr,0, arr.length-rf-1);
        reverse(arr, arr.length-rf, arr.length-1);

        reverse(arr, 0 , arr.length-1);
    }

    public static void reverse(int[] arr, int i , int j){
        while(i<j){
            int temp= arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }

    public static int[] fillOnedFromShell(int[][] arr, int s){
        int minr=s-1;
        int minc=s-1;
        int maxr=arr.length-s;
        int maxc=arr[0].length-s;
        int sz = 2 * (maxr-minr+1 + maxc-minc+1 ) - 4;
        int[] oned= new int[sz];

        int idx=0;
        //left
        for(int i=minr,j=minc; i<=maxr; i++){
            oned[idx]=arr[i][j];
            idx++;
        }
        minc++;
        //bottom
        for(int i=maxr,j=minc; j<=maxc; j++) {
            oned[idx] = arr[i][j];
            idx++;
        }
        maxr--;
        //right
        for(int i=maxr,j=maxc; i>=minr; i--){
            oned[idx]=arr[i][j];
            idx++;
        }
        maxc--;
        //top
        for(int i=minr,j=maxc; j>=minc; j--){
            oned[idx]=arr[i][j];
            idx++;
        }
        return oned;
    }

    public static void fillShellFromOned(int[][] arr, int s, int[] oned){
        int minr=s-1;
        int minc=s-1;
        int maxr=arr.length-s;
        int maxc=arr[0].length-s;

        int idx=0;
        //left
        for(int i=minr,j=minc; i<=maxr; i++){
            arr[i][j]=oned[idx];
            idx++;
        }
        minc++;
        //bottom
        for(int i=maxr,j=minc; j<=maxc; j++) {
            arr[i][j]=oned[idx];
            idx++;
        }
        maxr--;
        //right
        for(int i=maxr,j=maxc; i>=minr; i--){
            arr[i][j]=oned[idx];
            idx++;
        }
        maxc--;
        //top
        for(int i=minr,j=maxc; j>=minc; j--){
            arr[i][j]=oned[idx];
            idx++;
        }

    }

    public static void display(int[][] arr){
        for(int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }




}
