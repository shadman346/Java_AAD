package _recurssion;

import java.util.ArrayList;

public class GetStairPath {
    public static void main(String[]args){
        System.out.println(getPaths(5));
    }

    public static ArrayList<String> getPaths(int n){
        if(n==0){
            ArrayList<String> base1 = new ArrayList<>();
            base1.add("");
            return base1;
        }else if(n<0){
            ArrayList<String> base2 = new ArrayList<>();
            return base2;
        }

        ArrayList<String> allPaths= new ArrayList<>();
        for (int i=1;i<=n;i++){
            ArrayList<String> ways= getPaths(n-i);
            for(String path:ways){
                allPaths.add(i+path);
            }
        }

        return allPaths;
    }
}
