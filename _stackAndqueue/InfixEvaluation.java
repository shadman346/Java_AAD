package _stackAndqueue;

import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String str = "6+(5-3*6/2)";

        Stack<Integer> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (int i=0; i<str.length();i++){
            char ch = str.charAt(i);
            if(ch=='('){
                st2.push(ch);
            }else if(Character.isDigit(ch)){
                st1.push(ch-'0');
            }else if(ch==')'){
                while(!st2.isEmpty() && st2.peek()!='('){
                    int op1 = st1.pop();
                    int op2 = st1.pop();
                    int res = cal(op2,op1,st2.pop());
                    st1.push(res);
                }
                st2.pop();
            }else if(ch=='+' || ch=='-' || ch=='*' || ch=='/'){
                while(!st2.isEmpty() && st2.peek()!='('
                        && precedence(ch)<= precedence(st2.peek())){
                    int op1 = st1.pop();
                    int op2 = st1.pop();
                    int res = cal(op2,op1,st2.pop());
                    st1.push(res);
                }
                st2.push(ch);
            }else{
                System.out.println("Wrong expression");
                System.exit(-1);
            }
        }
        while(st2.size() !=0){
            int op1 = st1.pop();
            int op2 = st1.pop();
            int res = cal(op2,op1,st2.pop());
            st1.push(res);
        }
        System.out.println( st1.peek());
    }

    public static int precedence(char op){
        if (op == '+' || op == '-') {
            return 1;
        }
        if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    public static int cal(int op1, int op2, char ch){
        if (ch == '+') {
            return op1 + op2;
        }else if (ch=='-'){
            return op1 - op2;
        }else if (ch=='*'){
            return op1 * op2;
        }else if (ch=='/'){
            return op1/op2;
        }
        return 0;
    }

}
