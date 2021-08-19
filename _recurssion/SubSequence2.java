package _recurssion;

public class SubSequence2 {
    public static void main(String[]args){
        printSS("abc","");
    }

    public static void printSS(String ques, String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String restOfQues = ques.substring(1);

        printSS(restOfQues, ans + ch);
        printSS(restOfQues, ans + "");

    }
}
