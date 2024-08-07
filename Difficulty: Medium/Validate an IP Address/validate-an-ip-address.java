//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
        
        String s=str;
        int c=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='.'){
                c++;
            }
        
        }
        
        int b=0;
        if(c==3) {
            String s1="";
            for(int i=0;i<s.length();i++) {
                
                if(s.charAt(i)=='.') {
                    
                if(s1.equals("")) {
                        continue;
                    }
                    else {
                       if(s1.length()>=2){
                          int n=Integer.parseInt(s1);
                          if(0<=n && n<=9) {
                              continue;
                          }else {
                              if(n>=0 && n<=255) {
                                  b++;
                              }
                          }
                            
                         }else {
                        int n=Integer.parseInt(s1);
                        if(n>=0 && n<=255) {
                            b++;
                        }
                       }
                    }
                    s1="";
                    
                }else {
                    
                    s1=s1+s.charAt(i);
                    
                }
            }
            if(s1.length()>0) {
                int a=Integer.parseInt(s1);
                if(a>=0 && a<=255) {
                    b++;
                }
            }
        }
        
        
        if(b==4){
            return true;
        }
      return false;
    }
}