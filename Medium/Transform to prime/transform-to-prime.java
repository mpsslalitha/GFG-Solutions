//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            Solution ob = new Solution();
            int ans=ob.minNumber(a,n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minNumber(int arr[], int N) {
        int sum = Arrays.stream(arr).sum();
        int count = 0;

        while (!isPrime(sum)) {
            sum++;
            count++;
        }

        return count;
    }

    boolean isPrime(int x) {
        if (x <= 1) {
            return false;
        }
        
        if (x == 2 || x == 3) {
            return true;
        }

        if (x % 2 == 0 || x % 3 == 0) {
            return false;
        }

        int i = 5;
        while (i * i <= x) {
            if (x % i == 0 || x % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }

        return true;
    }
}
