//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        while(t > 0)
        {
            int n = in.nextInt();
            Geeks obj = new Geeks();
            System.out.println(obj.count(n));
            t--;
        }
    }
}
// } Driver Code Ends


// Complete this function!
class Geeks {
    public long count(int n) {
        // Add your code here.
        long[] dp = new long[n + 1];
        dp[0] = 1;
        int[] moves = {3, 5, 10};
        for (int move : moves) {
            for (int i = move; i <= n; i++) {
                dp[i] += dp[i - move];
            }
        }
        return dp[n];
    }
}