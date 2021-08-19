package _stackAndqueue;

import java.util.Stack;

public class NextGreaterEleOnRight2 {
    // left to right processing
    public static void main(String[] args) {
        int[] arr = {10,16,4,8,30,11,12,6,7,14};
        int[] ans = new int[arr.length];
        Stack<Integer> st= new Stack<Integer>();

        for(int i=0; i<arr.length;i++){
            while(st.size()>0 && arr[i]>arr[st.peek()]){
                ans[st.pop()]=arr[i];
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            ans[st.pop()]=-1;
        }

        for(int val:ans){
            System.out.println(val);
        }
    }
}
