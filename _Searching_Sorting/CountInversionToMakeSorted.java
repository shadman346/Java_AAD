package _Searching_Sorting;

public class CountInversionToMakeSorted {
    public static int count;
    public static void main(String[] args) {
        count=0;
        int[] arr = {2,4,1,3,5};
        inversionMergeSort(arr,0,arr.length-1);
        System.out.println(count);
        System.out.println("******************");
        for (int val:arr){
            System.out.println(val);
        }
    }

    public static void inversionMergeSort(int[] arr,int l, int h){
        if(l>=h) return;
        int mid = (l+h)/2;
        inversionMergeSort(arr, l, mid);
        inversionMergeSort(arr, mid + 1, h);
        merge_inversion(arr,l,h,mid);
    }

    private static void merge_inversion(int[] arr, int l, int h, int mid) {
        int[] left = new int[mid-l+1];
        int[] right = new int[h - mid];
        for (int i = 0; i < left.length; i++) {
            left[i]=arr[l+i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i]=arr[mid+1+i];
        }

        int i=0,j=0,k=l;
        while (i < left.length && j < right.length) {
            if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }else{
                count+=left.length-i;
                arr[k]=right[j];
                j++;
            }
            k++;
        }

        while(i< left.length){
            arr[k]=left[i];
            i++;k++;
        }
        while(j< right.length){
            arr[k] = right[j];
            j++;k++;
        }
    }
}
