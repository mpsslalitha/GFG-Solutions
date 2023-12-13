//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            long ans = new Solution().countStrings(n);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long countStrings(int n) {
        // code here
         if(n==1 || n==2) return n+1;
       
        int m = (int)1e9+7;
        
        long[]  dp= new long[n+1];
        dp[1]=2;
        dp[2]=3;
        
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]%m+dp[i-2]%m)%m;
        }
       
        return dp[n];
    }
}