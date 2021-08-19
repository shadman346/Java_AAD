package _recurssion;

import java.util.ArrayList;

public class GetKeyPadComb1 {
    public static void main(String[] args){
        ArrayList<String> words = getKPC("573");
        System.out.println(words);
    }

    static String[] codes = {".;","abc","def","ghi","jkl",
                            "mno","pqrs","tu","vwx","yz"};

    public static ArrayList<String> getKPC(String str){
        int btn = str.charAt(0)-'0';
        String code = codes[btn];

        if(str.length()==1){
            ArrayList<String> base = new ArrayList<>();
            for(int pos=0; pos<code.length(); pos++){
                base.add(String.valueOf(code.charAt(pos)));
            }
            return base;
        }
        ArrayList<String> grem = getKPC(str.substring(1));
        ArrayList<String> combos = new ArrayList<>();

        for(int pos=0; pos<code.length(); pos++){
            char ch = code.charAt(pos);
            for(String val:grem){
                combos.add(ch + val);
            }
        }
        return combos;

    }
}
