package _bitManupulation;
import java.util.*;
public class AppearsOnceAllOtherThrice {
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
        // 1111111    0000000     0000000
        int ThriceN=~0;
        int ThriceNp1=0;
        int ThriceNp2=0;

        int carry3n;
        int carry3np1;
        int carry3np2;

        for(int val:arr){
            carry3n = val & ThriceN;
            carry3np1 = val & ThriceNp1;
            carry3np2 = val & ThriceNp2;

            //step 1
            ThriceN = ThriceN & (~carry3n);  // off repetitive bit in 3n
            ThriceNp1 = ThriceNp1 | carry3n;  // transfer carry to 3n+1

            //step2
            ThriceNp1 = ThriceNp1 & (~carry3np1);
            ThriceNp2 = ThriceNp2 | carry3np1;

            //step3
            ThriceNp2 = ThriceNp2 & (~carry3np2); // off repetitive bit in 3n+2
            ThriceN = ThriceN | carry3np2; // transfer carry to 3n or we can say on bit in 3n

        }
        System.out.println(ThriceNp1); // because if sum of bits at nth bit is multiple of 3n then in answerMask that bit is off, so we are taking 3n+1 as 3n bit are off
    }
}
