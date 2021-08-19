package _bitManupulation;

// we need to count substrings from given string of binaries,
// such that after converting substring into decimal it lies in a given range
public class CountSubStringWithinValidRange {
    public static void main(String[] args) {
        String binary = "101";
        solve(binary,1,5);
    }

    private static void solve(String binary, int low, int high) {
        int i=0;
        int count = 0;
        while(i<binary.length()){
            int val = binary.charAt(i)-'0';
            if(val==low) count++; // for binary 1
            int j=i+1;
            while(val!=0 && j<binary.length()){
                val = val<<1;
                if(binary.charAt(j)-'0'==1){
                    val++;
                }
                if(val>=low && val<=high) count = count +1;
                if(val>high) break;
                j++;
            }
            i++;
        }

        System.out.println(count);
    }
}
