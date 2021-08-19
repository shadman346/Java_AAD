package _stackAndqueue;

import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] arr = {9,20,14,5};

        int[] idxL = new int[arr.length];  //store next_lowest_element idx on left for every ele
        int[] idxR = new int[arr.length];  //store next lowest element idx on Right for every ele
        Stack<Integer> st= new Stack<Integer>();

        //idxL
        for(int i=0 ; i<arr.length;i++){
            while(st.size()>0 && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                idxL[i]=-1;
            }else{
                idxL[i]=st.peek();
            }
            st.push(i);
        }

        //idxR
        for(int i=0; i<arr.length;i++){
            while (st.size()>0 && arr[i]<arr[st.peek()]){
                idxR[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            idxR[st.pop()]=arr.length;
        }

        //area
        int maxArea = 0;
        for(int i=0; i<arr.length; i++){
            int width = idxR[i] - idxL[i] -1;
            int area = arr[i] * width;
            maxArea= Math.max(maxArea, area);
        }
        System.out.println(maxArea);

    }

}
