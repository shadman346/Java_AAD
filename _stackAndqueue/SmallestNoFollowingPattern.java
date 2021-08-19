package _stackAndqueue;

import java.util.Stack;

public class SmallestNoFollowingPattern {
    public static void main(String[] args) {
        String str = "ddiddidd";

        Stack<Integer> st = new Stack<>();
        int count = 0;

        for (int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            count++;
            st.push(count);

            if(ch=='i') {
                while (!st.isEmpty()) {
                    System.out.print(st.pop() + " ");
                }
            }
        }

        if(str.charAt(str.length()-1)=='d'){
            count++;
            st.push(count);
            while(!st.isEmpty()){
                System.out.print(st.pop()+" ");
            }
        }

    }
}
