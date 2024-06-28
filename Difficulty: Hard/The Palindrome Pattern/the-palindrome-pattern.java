//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String input_line[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            String input_line1[] = read.readLine().trim().split("\\s+");
            int[][] a = new int[n][n];
            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(input_line1[c]);
                    c++;
                }
            }
            String ans = ob.pattern(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
      public String pattern(int[][] arr) {
        // Code here
        String rc="_";
        int res=-1;
        // checking in the row
        for(int i=0; i<arr.length; i++)
        {
            int m=arr[i].length;
            int q=m-1;
            int p=0;
            int flag=0;
            // checking for palindrome
            while(p<=q)
            {
                if(arr[i][p]!=arr[i][q])
                {
                    flag++;
                    break;
                }
                p++;
                q--;
            }
            if(flag==0 && res==-1)
            {
                res=i;
                rc="R";
                break;
            }
        }
        // check for columns only if res==-1
        if(res==-1)
        {
            // Atfirst transposing the matrix
            for(int i=0;i<arr.length-1; i++)
            {
                for(int j=i+1; j<arr.length; j++)
                {
                    // swap arr[i][j] with arr[j][i
                    int temp=arr[i][j];
                    arr[i][j]=arr[j][i];
                    arr[j][i]=temp;
                }
            }
            for(int i=0; i<arr.length; i++)
            {
                int m=arr[i].length;
                int q=m-1;
                int p=0;
                int flag=0;
                // checking for palindrome
                while(p<=q)
                {
                    if(arr[i][p]!=arr[i][q])
                    {
                        flag++;
                        break;
                    }
                    p++;
                    q--;
                }
                if(flag==0 && res==-1)
                {
                    res=i;
                    rc="C";
                    break;
                }
            }
        }
        String r="";
        if(res==-1)
        {
            r="-1";
        }else{
            r=r+res+" "+rc;
        }
        return r;
        
    }
}
