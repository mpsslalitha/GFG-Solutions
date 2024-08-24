//{ Driver Code Starts
import java.io.*;
import java.util.*;

class gfg {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int w = Integer.parseInt(br.readLine());

            String line = br.readLine();
            String[] tokens = line.split(" ");
            List<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] val = new int[array.size()];
            int idx = 0;
            for (int i : array) val[idx++] = i;

            String lin = br.readLine();
            String[] toke = lin.split(" ");
            List<Integer> array1 = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : toke) {
                array1.add(Integer.parseInt(token));
            }

            int[] wt = new int[array1.size()];
            idx = 0;
            for (int i : array1) wt[idx++] = i;

            // calling method knapSack() of class Solution
            System.out.println(new Solution().knapSack(w, wt, val));
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[]) {
       int n = val.length;
        int maxValue = 0;

   
        for (int i = 0; i < n; i++) {
          
            if (wt[i] <= W) {
                maxValue = Math.max(maxValue, val[i]);
            }

            for (int j = i + 1; j < n; j++) {
               
                int totalWeight = wt[i] + wt[j];
                int totalValue = val[i] + val[j];

                if (totalWeight <= W) {
                    maxValue = Math.max(maxValue, totalValue);
                }

                for (int k = j + 1; k < n; k++) {
                
                    totalWeight = wt[i] + wt[j] + wt[k];
                    totalValue = val[i] + val[j] + val[k];

                    if (totalWeight <= W) {
                        maxValue = Math.max(maxValue, totalValue);
                    }
                }
            }
        }

        return maxValue;
    }
}