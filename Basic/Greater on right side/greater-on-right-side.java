//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().nextGreatest(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java




class Solution {
    void nextGreatest(int arr[], int n) {
        // code here
         int crntGrt = arr[n-1];
        arr[n-1] = -1;


        for(int i=n-2; i>=0; i--){


           if(arr[i] > crntGrt){


               int temp = arr[i];
               arr[i] = crntGrt;
               crntGrt = temp;


           }else{


               arr[i] = crntGrt;
           }
        }
    }
}