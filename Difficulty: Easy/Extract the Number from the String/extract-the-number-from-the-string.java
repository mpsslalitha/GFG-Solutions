//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    long ExtractNumber(String sentence) {
        // code here
        
        long max=-1;
      String a[]=sentence.split(" ");
      for(String i:a)
      {
          if(i.contains("9")) continue;
          
          if(i.contains("0") ||  i.contains("1") || i.contains("2") || i.contains("3") || i.contains("4") || i.contains("5") || i.contains("6") || i.contains("7") || i.contains("8"))
            { 
                long num=Long.parseLong(i);
                if(num>max) max=num;
            }
      }
      return  max;
    }
}