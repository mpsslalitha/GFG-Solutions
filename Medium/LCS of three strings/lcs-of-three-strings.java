//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException 
    { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int LCSof3(String a, String b, String c, int n, int m, int k) 
    { 
        // code here
        int[][][] dp=new int[n+1][m+1][k+1];
 
for(int i=1;i<=n;i++){
for(int j=1;j<=m;j++){
for(int p=1;p<=k;p++){
// comparing character of 3 strings if equals than increase by 1
if(a.charAt(i-1)==b.charAt(j-1) && b.charAt(j-1)==c.charAt(p-1)){
dp[i][j][p]=1+dp[i-1][j-1][p-1];
}else{
// getting the max from i-1, j-1 and  p-1 
dp[i][j][p]=Math.max(dp[i-1][j][p],Math.max(dp[i][j-1][p],dp[i][j][p-1]));
}
}
}
}
return dp[n][m][k];
    }
}