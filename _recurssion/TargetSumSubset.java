package _recurssion;

public class TargetSumSubset {
    public static void main(String[]args){
        int[] arr = {10,20,30,40,50};
        int size = arr.length;
        targetSumSubset(arr,size-1, 60,"");
    }

    public static void targetSumSubset(int[]arr,int i, int sum, String prnt){
        if(sum==0){
            System.out.println(prnt.substring(0,prnt.length()-1));
            return;
        }
        if(i<0) return;

        if(arr[i]<=sum){
            targetSumSubset(arr,i-1,sum-arr[i],prnt + arr[i] + "+");
        }
        targetSumSubset(arr,i-1,sum,prnt);

    }
}
