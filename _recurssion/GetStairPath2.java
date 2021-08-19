package _recurssion;

public class GetStairPath2 {
    public static void main(String[]args){
        getPaths(5,"");
    }

    public static void getPaths(int x, String ans){
        if(x==0){
            System.out.println(ans);
            return;
        }

        for(int i=1;i<=x;i++){
            getPaths(x-i, ans + i);
        }
    }
}
