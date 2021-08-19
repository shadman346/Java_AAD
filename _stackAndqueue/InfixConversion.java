package _stackAndqueue;

import java.util.Stack;

public class InfixConversion {
    public static void main(String[] args) {
        String str = "a+b*c/d";

        Stack<Character> infix = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(ch=='('){
                infix.push(ch);
            }else if(Character.isDigit(ch) || (ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z') ){
                pre.push(String.valueOf(ch));
                post.push(String.valueOf(ch));
            }else if(ch==')'){
                while(infix.size() >0 && infix.peek()!='('){
                    process(pre,post,infix);
                }
                infix.pop();

            }else if(ch=='+' || ch=='-'||ch=='*'||ch=='/'){
                while(!infix.isEmpty() && infix.peek()!='(' && precedence(ch)<=precedence(infix.peek())){
                    process(pre,post,infix);
                }
                infix.push(ch);
            }
        }

        while(!infix.isEmpty()){
            process(pre,post,infix);
        }
        System.out.println(pre.peek());
        System.out.println(post.peek());
    }

    public static void process(Stack<String> pre, Stack<String> post, Stack<Character> infix){
        char ch = infix.pop();

        String valTop = pre.pop();
        String valBelow = pre.pop();
        String resultPre = ch + valBelow + valTop;
        pre.push(resultPre);

        valTop = post.pop();
        valBelow = post.pop();
        String resultPost = valBelow + valTop + ch ;
        post.push(resultPost);
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


}
