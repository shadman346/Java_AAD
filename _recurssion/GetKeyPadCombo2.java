package _recurssion;

public class GetKeyPadCombo2 {
    public static void main(String[]args){
        printCombo("797","");
    }

    static String[] codes = {".;","abc","def","ghi","jkl",
                            "mno","pqrs","tu","vwx","yz"};

    public static void printCombo(String ques, String ans){
        if(ques.length()==0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        String code = codes[ch-'0'];
        for(int pos=0 ; pos<code.length();pos++){
            printCombo(roq, ans + code.charAt(pos));
        }
    }
}
