//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            char[] nuts = new char[n], bolts = new char[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                nuts[i] = (inputLine[i].charAt(0));
            }
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                bolts[i] = (inputLine[i].charAt(0));
            }

            new Solution().matchPairs(n, nuts, bolts);
            for (int i = 0; i < n; i++) {
                System.out.print(nuts[i] + " ");
            }
            System.out.println();
            for (int i = 0; i < n; i++) {
                System.out.print(bolts[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        
        HashMap<Character,Integer> order = new HashMap<>();
        
        order.put('!',0);
        order.put('#',1);
        order.put('$',2);
        order.put('%',3);
        order.put('&',4);
        order.put('*',5);
        order.put('?',6);
        order.put('@',7);
        order.put('^',8);
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(order.get(nuts[i])<order.get(nuts[j])){
                    Character temp = nuts[i];
                    nuts[i] = nuts[j];
                    nuts[j] = temp;
                }
            }
        }
         for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(order.get(bolts[i])<order.get(bolts[j])){
                    Character temp = bolts[i];
                    bolts[i] = bolts[j];
                    bolts[j] = temp;
                }
            }
        }
        
    }


}