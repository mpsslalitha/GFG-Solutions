//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    static void merge(int[] nums, int low, int mid, int high) {
        int i = low, j = mid + 1, k = 0;
        
        int[] vc = new int[high - low + 1];
        
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
                vc[k++] = nums[i++];
            } else {
                vc[k++] = nums[j++];
            }
        }
        
        while (i <= mid) {
            vc[k++] = nums[i++];
        }
        
        while (j <= high) {
            vc[k++] = nums[j++];
        }
        
        for (k = low; k <= high; k++) {
            nums[k] = vc[k - low];
        }
    }
    
    static int count(int[] nums, int low, int mid, int high) {
        int res = 0;
        
        for (int i = low, j = mid + 1, cnt = 0; i <= mid; i++) {
            while (j <= high && nums[i] > nums[j]) {
                cnt++;
                j++;
            }
            res += cnt;
        }
        
        return res;
    }
    
    static int mergeSort(int[] nums, int low, int high) {
        int res = 0;
        if (low < high) {
            int mid = low + ((high - low) >> 1);
            res += mergeSort(nums, low, mid);
            res += mergeSort(nums, mid + 1, high);
            res += count(nums, low, mid, high);
            merge(nums, low, mid, high);
        }
        return res;
    }
    
    static int countPairs(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] * i;
        }
        
        return mergeSort(arr, 0, n - 1);
    }
}