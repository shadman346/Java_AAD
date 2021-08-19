package _recurssion;

public class PrintPermutaion {
    public static void main(String[]args){
        printP(new StringBuilder("abc"), "");
    }
    public static void printP(StringBuilder ques, String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<ques.length(); i++){
            String ch = String.valueOf(ques.charAt(i));
            ques.deleteCharAt(i);
            printP(ques,ans+ch);
            ques.insert(i,ch);
        }
    }
}
