package _stackAndqueue;

import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        String ques1 = "((a+b)+(c+d))";
        String ques2 = "(a+b)+((c+d))";
        String str =ques2;
        Stack<Character> st = new Stack<Character>();

        for(int i=0; i<str.length();i++){
        char ch = str.charAt(i);
            if(ch == ')') {
                if (st.peek() == '(') {
                    System.out.println(true);
                    return;
                } else {
                    while (st.peek() != '(') {
                        st.pop();
                    }
                    st.pop();
                }
            }else{
                st.push(ch);
            }
        }
        System.out.println(false);
    }

}
