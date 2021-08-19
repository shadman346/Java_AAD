package _recurssion;

public class PrintEncoding1 {
    public static void main(String[]args){
        printEncoding("1003","");
    }
    static String[] codes = {"","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static void printEncoding(String ques, String ans){
        if(ques.length()==0 || ques.charAt(0)=='0'){
            System.out.println(ans);
            return;
        }

        int ch0= ques.charAt(0)-'0';
        if(ch0 ==1){
            if(indexExists(ques,2)){
                printEncoding(ques.substring(2),ans + codes[(10+(ques.charAt(1)-'0'))]);
            }
        }else if(ch0 == 2){
            if(indexExists(ques,2) && ques.charAt(1)<=6){
                printEncoding(ques.substring(2),ans + codes[(10+(ques.charAt(1)-'0'))]);
            }
        }

        printEncoding(ques.substring(1),ans + codes[ch0]);


    }

    public static boolean indexExists(String array,int index){
        if(array!=null && index >= 0 && index < array.length())
            return true;
        else
            return false;
    }
}
