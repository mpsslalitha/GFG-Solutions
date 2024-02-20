//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        if(f(A, B, 0)) return 1;
        return 0;
    }
    static boolean f(String s, ArrayList<String> l, int ind){
        if(s.length() == 0) return true;
        if(ind > s.length()) return false;
        for(int i = ind; i < s.length(); i++)
        {
            if(l.contains(s.substring(ind, i+1))){
                if(f(s.substring(i+1), l, 0)) return true;
            }
        }
        return false;
    }
}