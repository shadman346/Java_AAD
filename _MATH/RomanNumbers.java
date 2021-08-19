package _MATH;

import java.util.*;

public class RomanNumbers {
    public static void main(String[] args) {


        HashMap<Integer,Integer> set = new HashMap<>();
        int[] arr = {23,12,43,12,65,-12,-4,-56};
        arr = Arrays.stream(arr).
                boxed().
                sorted((a, b) -> Math.abs(b)-Math.abs(a)).
                mapToInt(i -> i).
                toArray();
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }


    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        // Loop through each symbol, stopping if num becomes 0.
        for (int i = 0; i < values.length && num > 0; i++) {
            // Repeat while the current symbol still fits into num.
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
