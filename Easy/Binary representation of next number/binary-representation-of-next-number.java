//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s){
        int i; String ans; StringBuilder ss = new StringBuilder();
        for(i=s.length()-1;i>=0;i--) if(s.charAt(i) == '0') break;

        for(int j=0;j<s.length()-1-i;j++) ss.append("0");
        if(i >= 0){
            ans = s.substring(0,i) + "1" + ss;
        }
        else ans = "1" + ss;

        i = 0;
        for(i=0;i<ans.length();i++) if(ans.charAt(i) == '1') break;

        return ans.substring(i);
    }
}