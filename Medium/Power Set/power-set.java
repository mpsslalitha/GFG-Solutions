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
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
     public void solve(String s, int idx,String temp,List<String>ans)
    {
        if(idx==s.length())
        {
            if(temp.length()!=0)
            ans.add(temp);
            return;
        }
        
        //notInclude
        solve(s,idx+1,temp,ans);        
        
        
        //include
        solve(s,idx+1,temp+s.charAt(idx),ans);
    }
    public List<String> AllPossibleStrings(String s)
    {
        List<String>ans=new ArrayList<>();
        solve(s,0,"",ans);
        Collections.sort(ans);
        return ans;
    }
}