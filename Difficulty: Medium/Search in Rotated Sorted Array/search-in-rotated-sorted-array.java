//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            String line = in.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int key = Integer.parseInt(in.readLine().trim());

            out.println(new Solution().search(arr, key));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int search(int[] arr, int key) {
        // Complete this function
         int mini=arr[arr.length-1];
        int index= arr.length-1;
        for (int i = arr.length-2;i >=0 ; i--) {
            if (arr[i]<mini){
                mini=arr[i];
                index=i;
            }
        }
        int binarysearch2 = binarysearch(arr, 0, index - 1,key);
        int binarysearch1 = binarysearch(arr, index, arr.length - 1,key);
        if (binarysearch1==-1 && binarysearch2==-1){
            return -1;
        }
        else{
            return binarysearch1!=-1?binarysearch1:binarysearch2;
        }
    }

    private static int binarysearch(int[] arr, int index, int i,int key) {
        int start=index;
        int end=i;
        while(start<=end){
            int mid=(start+end)/2;
            if (arr[mid]==key){
                return mid;
            }
            else if(arr[mid]>key){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return -1;
    }
}