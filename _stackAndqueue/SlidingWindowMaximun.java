package _stackAndqueue;

import java.util.Stack;

public class SlidingWindowMaximun {
    public static void main(String[] args) {
        int k = 4; //window size;
        int[] arr= {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};

        int[] spanR= new int[arr.length]; // nextGreaterElementRight
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<arr.length;i++){
            while (st.size()>0 && arr[i]>arr[st.peek()]){
                spanR[st.pop()]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            spanR[st.pop()]=-1;

        }

        int j=0;  // for better optimization
        for(int i=0; i< arr.length; i++){
            if(j<i) {
                j = i;
            }
            while(spanR[j]!=-1 && spanR[j]-i<k){  // checking within the range of window
                j=spanR[j];
            }
            System.out.println(arr[j]);

        }
    }
}
