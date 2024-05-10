//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);
            List<List<Integer>> ans = new Solution().CombinationSum2(a, n, k);
            for (List<Integer> list : ans) {
                for (int x : list) ot.print(x + " ");
                ot.println();
            }
            if (ans.size() == 0) ot.println();
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<List<Integer>> CombinationSum2(int arr[], int n, int k) {
        // Code Here.
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int[] dp = new int[k + 1];
        dp[0] = 1; // Base case

        for (int num : arr) {
            for (int i = k; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        findCombinations(result, new ArrayList<>(), arr, dp, k, 0);
        return result;
    }

    private void findCombinations(List<List<Integer>> result, List<Integer> tempList, int[] arr, int[] dp, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) {
            result.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < arr.length; i++) {
                if (i > start && arr[i] == arr[i - 1]) continue; // Skip duplicates
                if (remain < arr[i]) break; // Optimization: if remaining sum is less than current number, break

                tempList.add(arr[i]);
                findCombinations(result, tempList, arr, dp, remain - arr[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}