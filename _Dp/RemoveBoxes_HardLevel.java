package _Dp;

import java.util.HashMap;
// wrong answer solution , trash !!
public class RemoveBoxes_HardLevel {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        map = new HashMap<>();
        System.out.println(removeBoxes(arr));
    }
    static HashMap<Integer,Integer> map;
    public static int removeBoxes(int[] boxes) {
        boolean flag = false;
        int i=0,j=0,k=1;
        if(map.containsKey(0)) {
            k=map.get(0) + 1 ;
            i=j=k;
        }
        int points =0;
        for(; k<boxes.length; k++ ){
            int tempPoints=0;
            if(map.containsKey(k)){
                k = map.get(k);
            }else if(k==boxes.length-1){
                map.put(i,boxes.length-1);
                int boxCount = j-i+1;
                tempPoints =(boxCount*boxCount) + removeBoxes(boxes);
                map.remove(i);
                flag=true;
            }else if(boxes[k]==boxes[i]){
                j=k;
                flag=true;
            }else {
                map.put(i,j);
                int boxCount = j-i+1;
                tempPoints =(boxCount*boxCount) + removeBoxes(boxes);
                map.remove(i);
                i=k;
                j=k;
                flag=true;
            }
            points = Math.max(points,tempPoints);
        }
        if(!flag){
            return 0;
        }

        return points;
    }
}
