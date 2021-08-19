package _bitManupulation;
import java.util.*;

public class AllRepeatingExcept2 {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);
    }

    public static void solution(int[] arr){
        //write your code here
        int twoUniq = 0;
        for(int val:arr){
            twoUniq = twoUniq ^ val;
        }

        int rmsb = -twoUniq & twoUniq;


        int first=0;
        int second=0;
        for(int val:arr){
            if((val & rmsb)==0){
                first = first ^ val;
            }else{
                second = second ^ val;
            }
        }

        if(first<second){
            System.out.println(first);
            System.out.println(second);
        }else{
            System.out.println(second);
            System.out.println(first);
        }
    }

}
