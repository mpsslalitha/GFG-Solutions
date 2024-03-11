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
            String input[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            
            int mat1[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat1[i][j] = Integer.parseInt(input[j]);
                }
            }
            
            int mat2[][] = new int[n][n];
            
            for(int i = 0;i<n;i++){
                input = read.readLine().split(" ");
                for(int j = 0;j<n;j++){
                    mat2[i][j] = Integer.parseInt(input[j]);
                }
            }
            
        
            
            Solution ob = new Solution();
            System.out.println(ob.countPairs(mat1,mat2,n,x));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
        // code here
        int i=0;
        int j=0;
        int k = n-1;
        int l = n-1;
        int count=0;
        while(i<mat1.length && k>=0){
            j=0;
            while(j<mat1.length){
                if(mat1[i][j]+mat2[k][l]==x){
                    count++;
                    j++;
                    if(l==0){
                        k--;
                        l=n;
                    }
                    if(k<0)
                        break;
                    l--;
                
                }  
                else if(mat1[i][j]+mat2[k][l]>x){
                    if(l==0){
                        k--;
                        l=n;
                    }
                    if(k<0)
                        break;
                    l--;
                }
                else
                    j++;
                }
            i++;
        }
        return count;
    }
}