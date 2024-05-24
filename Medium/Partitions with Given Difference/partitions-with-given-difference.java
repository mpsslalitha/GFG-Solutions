//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int d;
            d = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countPartitions(n, d, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    static int mod = 1000000007;
    public static int countPartitions(int n, int d, int[] arr) {
        // code here
        int sum = 0;
        for(int i = 0 ;i <n;i++)
        {
            sum += arr[i];
        }
        int dp[][] = new int[n][sum +1];
        for(int[] x: dp)
        {
        Arrays.fill(x,-1);
        }
        return rep(n,d,sum,arr,0,0,dp);
    }
    public static int rep(int n,int d,int sum,int arr[],int temp,int ind,int dp[][] )
    {
        if((sum - temp - temp) < d)
        return 0;
        if(ind == n)
        {
            int secondsum = sum - temp;
            if(secondsum - temp == d)
               return 1;
               
               return 0;
        }
        if(dp[ind][temp] != -1) return dp[ind][temp];
        int a = rep(n,d,sum,arr,temp,ind +1,dp);
        int b = rep(n ,d,sum,arr,temp + arr[ind],ind + 1,dp);
        return dp[ind][temp] = (a + b)% mod;
    }
}