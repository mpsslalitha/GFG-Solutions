//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            String A = obj.minSum(a);
            System.out.println(A);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum sum of two numbers formed using the array elements
    String minSum(int[] arr) {
        // Step 1: Sort the array
        Arrays.sort(arr);
        
        // Step 2: Create two numbers as strings
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        
        // Step 3: Distribute digits alternately between num1 and num2
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }
        
        // Step 4: Use the addStrings function to add two large numbers represented as strings
        String sum = addStrings(num1.toString(), num2.toString());
        
        // Step 5: Return the sum as a string without leading zeroes
        return removeLeadingZeros(sum);
    }

    // Function to add two large numbers represented as strings
    String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        
        // Add digits from right to left
        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) sum += num1.charAt(i--) - '0';
            if (j >= 0) sum += num2.charAt(j--) - '0';
            
            result.append(sum % 10);
            carry = sum / 10;
        }
        
        // Reverse the result to get the correct order
        return result.reverse().toString();
    }
    
    // Function to remove leading zeroes from a string
    String removeLeadingZeros(String str) {
        int i = 0;
        while (i < str.length() && str.charAt(i) == '0') {
            i++;
        }
        // Return "0" if all characters are zero
        return i == str.length() ? "0" : str.substring(i);
    }
}
