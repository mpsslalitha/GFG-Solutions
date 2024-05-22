//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java



// User function Template for Java

class Pair implements Comparable<Pair>{
    int a,diff;
    public Pair(int a,int diff){
        this.a=a;
        this.diff=diff;
        
    }
    @Override
    public int compareTo(Pair p2){
        if(this.diff-p2.diff!=0){
            return this.diff-p2.diff;
        }
        return p2.a-this.a;
    }
}
class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        int []ans=new int[k];
        PriorityQueue<Pair>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            if(x-arr[i]!=0) pq.add(new Pair(arr[i],Math.abs(x-arr[i])));
            if(pq.size()>k){
                pq.remove();
            }
        }
        int i=k-1;
        while(!pq.isEmpty()){
            Pair cur=pq.remove();
            ans[i--]=cur.a;
            
        }
        return ans;
        
    }
}
