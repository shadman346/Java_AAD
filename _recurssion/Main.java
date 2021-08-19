package _recurssion;

public class Main {
    public static void main(String[] args){
        int[]arr={2,3,4,8,4,3,7,8,9};
        int[] ans = allIndices(arr,0,8,0);
        for (int val:ans ){
            System.out.println(val);
        }
    }

    public static void printIncDec(int x){
        if(x==0){
            return;
        }
        System.out.println(x);
        printIncDec(x - 1);
        System.out.println(x);

    }

    public static int power(int x, int pow){
        if(pow==1){
            return x;
        }
        if (pow%2 == 0){
            return power(x,pow/2) * power(x,pow/2);
        }else{
            return power(x,pow/2) * power(x,pow/2) * x;
        }

    }
    public static int firstIndex(int[] arr, int idx, int x) {
        if (idx == arr.length) return -1;
        if (arr[idx] == x) return idx;
        return firstIndex(arr, idx + 1, x);
    }

    public static int lastIndex(int[]arr, int idx, int x){
        if(idx < 0) return -1;
        if(arr[idx]==x) return idx;
        return lastIndex(arr,idx-1,x);
    }

    public static int[] allIndices(int[] arr,int idx, int x , int flag){
        if(idx==arr.length) return new int[flag];

        if(arr[idx]==x) {
            int[] iarr = allIndices(arr,idx+1, x,flag+1);
            iarr[flag]=idx;
            return iarr;
        } else {
            int[] iarr = allIndices(arr, idx + 1, x, flag);
            return iarr;
        }

    }


}
