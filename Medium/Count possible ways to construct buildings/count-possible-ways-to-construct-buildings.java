//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.TotalWays(N);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int TotalWays(int n)
    {
        // Code here
        long mod = 1000000007, a = 2, b = 3;
        if (n == 1)
            return 4;
    
        if (n == 2)
            return 9;
    
        for (int i = 3; i <= n; i++)
        {
            long c = (a + b) % mod;
            a = b;
            b = c;
        }
    
        return (int) ((b * b) % mod);
    }
}