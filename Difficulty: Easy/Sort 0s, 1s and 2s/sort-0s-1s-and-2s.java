//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> a = new ArrayList<>();

            for (String s : inputArray) {
                a.add(Integer.parseInt(s));
            }

            Solution ob = new Solution();
            ob.sort012(a);

            for (int num : a) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int zeroCount = 0 , oneCount = 0 , twoCount = 0;
        for(int i = 0 ; i < arr.size() ; i++){
            if(arr.get(i) == 0)
                zeroCount++;
            else if (arr.get(i) == 1)
            oneCount++;
            else 
            twoCount++;
        }
        int i = 0;
        while(i < zeroCount){
            arr.set(i , 0);
            i++;
        }
        while(i < zeroCount+ oneCount){
            arr.set(i , 1);
            i++;
        }
        while(i < zeroCount+ oneCount + twoCount){
            arr.set(i , 2);
            i++;
        }
    }
}