package _bitManupulation;
import java.util.*;

public class JosephusSpecial {
    public static int mask2L(int n){
        int maskFor2L=0;

        while(n!=0)
        {
            int mask = -n;
            maskFor2L = n & mask; //right most significant bit
            n = n - maskFor2L;
        }
            return ~maskFor2L;
    }
    public static int solution(int n){
        //write your code here
        int mask = mask2L(n);
        int l = n & mask;
        return 2*l + 1;
    }
    public static void main(String[] args){

        int n = 5;
        System.out.println(solution(n));

    }
}
