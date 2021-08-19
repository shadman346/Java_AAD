package _stackAndqueue;

import java.util.Stack;

public class StockSpan {
    // similar to NextGreaterEleOnRight and you can call it NextGreaterEleOnLeft
    public static void main(String[] args) {
        int[] arr = {10,16,4,8,30,11,12,6,7,14};
        int[] span = new int[arr.length];
        Stack<Integer> st= new Stack<Integer>();

        for(int i=0; i<arr.length; i++){

            while(st.size()>0 && arr[i]>arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                span[i]= i+1;
            }else{
                span[i]= i-st.peek() ;
            }
            st.push(i);
        }

        for(int val:span){
            System.out.println(val);
        }
    }

}
