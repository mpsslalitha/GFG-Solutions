//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.smithNum(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    static int sumOfDigits(int n){
        int s = 0;
        while(n > 0){
            int r = n%10;
            s += r;
            n = n/10;
        }
        return s;
    }
    static int sumOfFactors(int n){
        int k = 1, s1= 0;
        while(n > 1){
            k++;
            if(!isPrime(k)) continue;
            while(n%k == 0){
                s1 += sumOfDigits(k);
                n /= k;
            }
        }
        return s1;
    }
    static int smithNum(int n) {
        // code here
        if(isPrime(n)) return 0;
        int sum = sumOfDigits(n);
        int factors = sumOfFactors(n);
        if(sum == factors) return 1;
        else return 0;
    }
};