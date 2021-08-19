package _stackAndqueue;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String ques1 = "[(a+b)+{(c+d)*(e/f)}]";
        String ques2 = "[(a+b)+{(c+d)*(e/f]}";
        String str =ques1;
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<str.length();i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (st.peek() != '(') {
                    System.out.println(false);
                    return;
                }
                st.pop();
            } else if (ch == '}') {
                if (st.peek() != '{') {
                    System.out.println(false);
                    return;
                }
                st.pop();
            } else if (ch == ']') {
                if (st.peek() != '[') {
                    System.out.println(false);
                    return;
                }
                st.pop();
            } else if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
        }
        if(st.isEmpty()==true) {
            System.out.println(true);
        }else System.out.println(false);
    }

}
