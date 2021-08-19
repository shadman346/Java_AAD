package _Extra;

public class DP_leetQ {
    static class production{
        int tSpeed;
        int minFreq;
        production(){
            this.tSpeed = 0;
            this.minFreq = 0;
        }

        public int workDone(){
            return this.tSpeed * this.minFreq;
        }
    }

    static production[][] dp = new production[100][100];

    public static void initializeBase(production[][] dp,int si, int sj){
        for(int i=0; i<si;i++) {
            for (int j = 0; j < sj; j++) {
                dp[i][j] = new production();
                if(i==0 || j==0) {
                    dp[i][j].minFreq = Integer.MAX_VALUE;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] speed = {2,4,3,7,5,9};
        int[] freq = {6,3,5,2,4,2};
        int k =3;
        int size = speed.length;

        int ans = solve(speed, freq, size,k);
        System.out.println(ans);
        display(dp,size,k);
    }
    public  static void display(production[][]dp,int sz, int k){
        for(int i =0 ; i<=sz; i++){
            System.out.println();
            for(int j=0; j<=k; j++){
                System.out.print(dp[i][j].tSpeed + " ");
            }
            System.out.print("\t");
            for(int j=0; j<=k; j++){
                System.out.print(dp[i][j].minFreq + " ");
            }

        }
    }
    public static int solve(int[]s, int[]frq, int sz, int count ){
            initializeBase(dp,sz+1, count+1);

            for(int i = 1 ; i<=sz ; i++){
                for(int j=1; j<=count; j++  ){
                    production temp1 = new production();
                    production temp2 = new production();

                    // including engineer
                    temp1.tSpeed= s[i-1] + dp[i-1][j-1].tSpeed;
                    temp1.minFreq= Math.min(dp[i - 1][j - 1].minFreq, frq[i-1]);

                    //excluding engineer
                    temp2.tSpeed= dp[i-1][j].tSpeed;
                    temp2.minFreq = dp[i-1][j].minFreq;

                    // max work done
                    if(temp1.workDone() >= temp2.workDone()){
                        dp[i][j]=temp1;
                    }else{
                        dp[i][j]=temp2;
                    }
                }
            }
            return dp[sz][count].workDone();
    }
}
