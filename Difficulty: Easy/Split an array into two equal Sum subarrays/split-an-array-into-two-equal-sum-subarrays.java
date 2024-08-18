//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int a[]) {
        // code here
      int sum=Arrays.stream(a).sum();
      int sumr=0;
      boolean status=false;
      for(int i=a.length-1;i>=0;i--){
          sumr=sumr+a[i];
          if(sumr==(sum-a[i])){
              status=true;
              break;
          }
          else{
              sum=sum-a[i];
          }
      }
      if(status)
      return true;
      
      else
      return false;
        
    }
}

