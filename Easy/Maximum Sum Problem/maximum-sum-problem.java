//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSum(n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int maxSum(int n) 
    { 
        //code here.
        int ans = solve(n);
        return ans;
    } 
    public static int solve(int n){
        if(n == 0) return 0;
        int ans = solve(n/2) + solve(n/3) + solve(n/4);
        return Math.max(n,ans);
    }
}
