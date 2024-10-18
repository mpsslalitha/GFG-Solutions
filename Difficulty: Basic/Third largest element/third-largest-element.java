//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (long i : array) arr[idx++] = (int)i;

            Solution obj = new Solution();

            // calling maxSubarraySum() function
            System.out.println(obj.thirdLargest(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    int thirdLargest(int arr[]) {
        // Your code here
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }
            else if(arr[i] > max2 ){
                max3 = max2;
                max2 = arr[i];
            }
            else if(arr[i] > max3 ){
                max3 = arr[i];
            }
        }
        return max3;
    }
}
