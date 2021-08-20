package _Searching_Sorting;

public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
    int[] arr ={ 1,3,5,5,5,6,8};
    int size = arr.length;
    int[]ans=new int[2];
    ans[0]=binarySearch_left(arr,0,size-1,3);
    if(ans[0]==-1) System.out.println("not found");
    else {
        ans[1] = binarySearch_right(arr, 0, size - 1, 3);
        System.out.println(ans[0] + "---" + ans[1]);
    }
    }

    public static int binarySearch_left(int[] arr,int lo,int hi,int t){
        while (lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]<t){
                lo=mid+1;
            }else if(arr[mid]>t){
                hi=mid-1;
            }else{
                hi=mid-1;
            }
        }
        if((hi==-1 && arr[0]!=t) || lo==arr.length) return -1;
        return lo;
    }
    public static int binarySearch_right(int[]arr,int lo,int hi,int t){
        while (lo<=hi){
            int mid = (lo+hi)/2;
            if(arr[mid]<t){
                lo=mid+1;
            }else if(arr[mid]>t){
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        if(hi==-1 || (lo==arr.length && arr[arr.length-1]!=t)) return -1;
        return hi;
    }
}
