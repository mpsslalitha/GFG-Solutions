//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int maximizeCuts(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        
        // Fill dp array with -1 to indicate that the value has not been computed yet
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        
        // Start the recursive approach
        int result = maximizeCutsHelper(n, x, y, z, dp);
        
        // If the result is negative, that means no valid cuts could be made, so return 0
        return result < 0 ? 0 : result;
    }
    
    private int maximizeCutsHelper(int n, int x, int y, int z, int[] dp) {
        // Base Case: If length is 0, no more cuts are needed
        if (n == 0) return 0;
        
        // If the length is negative, return a large negative value indicating invalid cuts
        if (n < 0) return Integer.MIN_VALUE;
        
        // If the result is already computed, return it
        if (dp[n] != -1) return dp[n];
        
        // Recursively calculate the maximum cuts possible by cutting with x, y, and z
        int cutX = maximizeCutsHelper(n - x, x, y, z, dp) + 1;
        int cutY = maximizeCutsHelper(n - y, x, y, z, dp) + 1;
        int cutZ = maximizeCutsHelper(n - z, x, y, z, dp) + 1;
        
        // Store the result in the dp array and return the maximum value
        dp[n] = Math.max(cutX, Math.max(cutY, cutZ));
        
        return dp[n];
    }
}
