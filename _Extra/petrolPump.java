package _Extra;

// wrong solution
public class petrolPump {
    public static void main(String[] args) {
        int startFuel=2;
        int[]fuel = {3,1,5,6,2,8,0};
        int[]dist = {1,2,5,10,13,15,20};
        int fuelstations = fuel.length;
        initialize(fuelstations,startFuel);
        int ans  = solve(fuel,dist,fuelstations);
        System.out.println(ans);
    }

    static int[][] dp = new int[8][8];
    public static void initialize(int size , int startfuel){
        for(int j=0; j<=size;j++){
            if(j<=startfuel){
                dp[0][j]=0;
            }else {
                dp[0][j]=Integer.MAX_VALUE;
            }
        }

    }
    public static int solve(int[]fuel, int[]dist, int fuelPoint){

        for(int i = 1; i<= fuelPoint; i++){
            for(int j = i+1; j<= fuelPoint; j++){
                if(fuel[i-1] - (dist[j-1]-dist[i-1])<0){
                    // fuel will not added as it unable cover the distance between two points

                    dp[i][j]=dp[i-1][j] ;
                }else{
                    // when not added fuel at station i
                    int cond1 = dp[i-1][j];
                    //when added fuel at station i
                    int cond2 = dp[i-1][i] + 1;
                    dp[i][j]= Math.min(cond1,cond2);
                }
            }
        }
        return dp[fuelPoint][fuelPoint];
    }
}
