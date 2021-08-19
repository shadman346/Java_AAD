package _recurssion;

import java.util.ArrayList;

public class SubSequence1 {
    public static void main(String[] args){

        System.out.println(gss("abc"));
    }

    public static ArrayList<String> gss(String str){
        if(str.length()==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        char ch = str.charAt(0);
        String ros = str.substring(1);
        ArrayList<String> rres = gss(ros);

        ArrayList<String> resStr = new ArrayList<>();
        for (String rstr:rres){
            resStr.add("" + rstr);
            resStr.add(ch + rstr);
        }
        return resStr;
    }
}
