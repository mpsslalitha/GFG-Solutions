//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int f(int ind, int[] dp){
        if(ind == 0){
            return 1;
        }
        
        if(ind < 0){
            return 0;
        }
        
        if(dp[ind]!=-1){
            return dp[ind];
        }
        
        return dp[ind] = 1 + Math.min(f(ind-1, dp), f(ind-2, dp));
    }
    public int nthStair(int n) {
        // Code here
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return f(n, dp);
    }
}