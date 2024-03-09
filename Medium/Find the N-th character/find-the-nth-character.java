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
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        String answer = s;
int i=0;
while(i<r){
    String temp = "";
    for(int j=0;j<s.length();j++){
        if(answer.charAt(j)=='1'){
            temp += "10";
        }else if(answer.charAt(j) == '0'){
            temp += "01";
        }
    }
    answer = temp;
    i++;
}
return answer.charAt(n);
    }
}