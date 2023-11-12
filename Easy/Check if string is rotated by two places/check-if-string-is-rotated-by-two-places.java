//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t;
		t = sc.nextInt();
		String s12 = sc.nextLine();
		for(int i=0; i<t; i++){
		    String s1 = sc.nextLine();
		    String s2 = sc.nextLine();
		    
		    Solution obj = new Solution();
		    
		    boolean flag = obj.isRotated(s1, s2);
		    
		    if(flag == true) System.out.println("1");
		    else System.out.println("0");
		    
		}
	}
}
// } Driver Code Ends


class Solution
{
    public static boolean isRotated(String str1, String str2)
    {
        int flag = 0, n = str1.length(), m = str2.length();
        for(int i = 0; i < n; i++)  
            if(str1.charAt((i + 2) % n) != str2.charAt(i))
                flag = 1;
                
        if(flag == 1) {
            for(int i = 0; i < n; i++)  
                if(str1.charAt(i) != str2.charAt((i + 2) % m))
                    return false;
        }
        
        return true;
    }
}