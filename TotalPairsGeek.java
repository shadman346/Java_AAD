import java.util.Arrays;

public class TotalPairsGeek {
    public static void main(String[] args) {
        int[] arr = {3,5,5,2,6};
        TotalPairsGeek obj = new TotalPairsGeek();
        int val =obj.TotalPairs(arr,8,13);
        System.out.println(val);
    }

     int TotalPairs(int[] arr, int x, int y) {
        int countPairs=0;
        Arrays.sort(arr);
        for(int i=0; i< arr.length-1;i++){
            int a =ceilDivide(x,arr[i]);
            int b = y/arr[i];
            int startPoint = binarySearchLeftSide(arr,i+1,arr.length-1,a);
            int endPoint = binarySearchRightSide(arr,i+1,arr.length-1,b);
            if(startPoint<=endPoint) {
                int pairs = endPoint - startPoint + 1;
                countPairs += pairs;
            }
        }
        return countPairs;
    }

    private int ceilDivide(int x, int i) {
        if(x%i==0){
            return x/i;
        }else{
            return (x/i)+1;
        }
    }

    int binarySearchLeftSide(int[] arr, int i, int j, int find) {
        int startIdx = -1;
        while (i<=j){
            int mid = (i+j)/2;
            int midVal= arr[mid];
            if(midVal==find){
                startIdx=mid;
                j=mid-1;
            }else if(find<midVal){
                j=mid-1;
            }else if(find>midVal){
                i=mid+1;
            }
        }
        if(startIdx!=-1){
            return startIdx;
        }else{
            return i;
        }
    }

    int binarySearchRightSide(int[] arr, int i, int j, int find) {
        int endIdx = -1;
        while (i<=j){
            int mid = (i+j)/2;
            int midVal= arr[mid];
            if(midVal==find){
                endIdx =mid;
                i=mid+1;
            }else if(find<midVal){
                j=mid-1;
            }else if(find>midVal){
                i=mid+1;
            }
        }
        if(endIdx !=-1){
            return endIdx;
        }else{
            return j;
        }

    }


}
