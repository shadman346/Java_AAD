package _stackAndqueue;

import java.util.Stack;

public class NextGreaterEleOnRight {
    // right to left processing
    public static void main(String[] args) {
        int[] arr = {10,16,4,8,30,11,12,6,7,14};
        int[] ans = new int[arr.length];
        Stack<Integer> st= new Stack<Integer>();
        for(int i=arr.length-1; i>=0;i--){
            while(!st.isEmpty() && arr[i]>=st.peek()){
                st.pop();
            }

            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }

            st.push(arr[i]);

        }

        for(int val:ans){
            System.out.println(val);
        }
    }
}
