import java.util.HashMap;

public class SovleDp1 {
    public static void main(String[] args) {
        int[] arr= {7,1,5,2,6,4};
        int n = arr.length;

        int ans =solveDp(arr,n-1,Integer.MAX_VALUE,3);
        System.out.println(ans);
    }
    static int ct=0;
    static HashMap<String,Integer> map = new HashMap<>();
    public static int solveDp(int[]arr,int i,int num, int count ){
        if(count==0 || i<0){
            return 0;
        }
        String str = ""+i +"_"+num+"_"+count;
        if(map.containsKey(str)){
            return map.get(str);
        }

        int ans ;
        if(num >=arr[i]){
            int sum = arr[i] + solveDp(arr,i-1,arr[i],count-1);
            int sum2 = solveDp(arr,i-1,num ,count);
            ans = Math.max(sum, sum2);
        }else{
            ans = solveDp(arr,i-1,num ,count);
        }
        map.put(str,ans);
        return ans;
    }


//    public static int solve(int[] arr,int i,int num, int count){
//        if(count==0 || i<0){
//            return 0;
//        }
//
//        int ans =-1 ;
//        if(num >=arr[i]){
//            int sum = arr[i] + solve(arr,i-1,arr[i],count-1);
//            int sum2 = solve(arr,i-1,num ,count);
//            ans = sum>=sum2? sum : sum2;
//        }else{
//            int sum2 = solve(arr,i-1,num ,count);
//            ans = sum2;
//        }
//        return ans;
//    }

}
