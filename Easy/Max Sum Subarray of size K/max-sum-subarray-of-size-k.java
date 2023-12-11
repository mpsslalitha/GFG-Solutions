//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            
            int N=sc.nextInt();
            int K=sc.nextInt();
            ArrayList<Integer> Arr = new ArrayList<Integer>(N); 
  
            // Appending new elements at 
            // the end of the list 
            for (int i = 0; i < N; i++) {
                int x = sc.nextInt();
                Arr.add(x); 
            }

            Solution ob = new Solution();
            System.out.println(ob.maximumSumSubarray(K,Arr,N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static long maximumSumSubarray(int k, ArrayList<Integer> arr,int n){
        //just apply sliding window algorithm
        long sum = 0;
        long value = Integer.MIN_VALUE;
        for(int i=0;i<k;i++){
            sum+=arr.get(i);
        }
        value = Math.max(sum,value);
        for(int i=1;i<=arr.size()-k;i++){
            int j = i+k-1;
            sum = sum + arr.get(j) - arr.get(i-1);
            value = Math.max(sum,value);
        }
        return value;

    }
}