//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countNumberswith4(int n) {
    // If n is less than 4, no number from 1 to n contains the digit 4
    if (n < 4) return 0;
    
    int count = 0;  // Initialize count of numbers containing '4'
    for (int i = 4; i <= n; i++) {
        int temp = i;  // Temporary variable to store current number
        while (temp > 3) {
            int digit = temp % 10;  // Get the last digit of the number
            if (digit == 4) {  // Check if the digit is '4'
                count++;  // Increment count
                break;  // Break as we found '4' in this number
            }
            temp = temp / 10;  // Remove the last digit
        }
    }
    return count;  // Return the count of numbers containing '4'
}
}
