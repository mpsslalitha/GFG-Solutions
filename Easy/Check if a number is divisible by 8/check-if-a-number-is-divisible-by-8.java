//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int DivisibleByEight(String s){
        //code here
        if(s.length() == 0) return -1;
        
        int num = 0;
        // If the string is too long we'll take only last 3 digits
        num = Integer.parseInt(s.substring(Math.max(0, s.length() - 3)));
        
        if(num % 8 == 0) return 1;
        
        return -1;
    }
}