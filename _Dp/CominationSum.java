package _Dp;

import java.util.ArrayList;
import java.util.List;

public class CominationSum {
    public static void main(String[] args) {
        int[] arr = {2,3,6,7};
        List<List<Integer>> ans =combinationSum(arr,7);
        System.out.println(ans);
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>[][]dp = new List[candidates.length+1][target+1];

        for(int i=0;i<=candidates.length;i++){
            for(int j=0; j<=target;j++){
                dp[i][j]=new ArrayList();
                if(i==0 || j==0){
                    if(j==0){
                        List<Integer> list = new ArrayList();
                        dp[i][j].add(list);
                    }
                    // do nothing
                }else if(candidates[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    //top
                    for(int k=0; k<dp[i-1][j].size();k++){
                        List<Integer> list = dp[i-1][j].get(k);;
                        dp[i][j].add( list );
                    }
                    //left
                    for(int k=0; k<dp[i][j-candidates[i-1]].size();k++){
                        List<Integer> list = new ArrayList();
                        list.addAll( dp[i][j-candidates[i-1]].get(k));
                        list.add(candidates[i-1]);
                        dp[i][j].add( list );
                    }
                }
            }
        }
        return dp[candidates.length][target];
    }
}
