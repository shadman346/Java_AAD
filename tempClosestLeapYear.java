import java.util.Scanner;

public class tempClosestLeapYear {
    public static void main(String[] args) {
        int t;
        Scanner scn = new Scanner(System.in);
        t = scn.nextInt();
        while (t-- > 0) {
            int yr;
            yr = scn.nextInt();
            closestLeapYear(yr);
        }
    }

    private static void closestLeapYear(int yr) {
        int rem = yr%4;
        int leapYear = rem<2?yr-rem : yr+1;
        if(leapYear%100 == 0 & leapYear%400!=0){
            if(yr<leapYear) leapYear-=4;
            else leapYear = leapYear +4;
        }
        System.out.println(leapYear);
    }
}
