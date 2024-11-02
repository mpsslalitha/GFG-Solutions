//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public boolean checkDuplicatesWithinK(int[] arr, int k) {
        // your code
         int i=0;
        int j=0;
        int n = arr.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(j<n){
            map.put(arr[j], map.getOrDefault(arr[j],0)+1);
            // if map size is equal to length of current subarray, that means, there is no duplicate
            // in current subarray, so keep increasing right(j) pointer,
            if(map.size() == j-i+1){
                j++;
                
            }
            
            // if we get any repeating number, then check for your condition.
            else{
                // since we have to find the duplicate in k size window, so keep increasing the 
                // left pointer(i), and decrease the frequency of value at ith index.
                while(map.size() > k){
                    if(map.containsKey(arr[i])){
                        map.put(arr[i],map.getOrDefault(arr[i],0)-1);
                    }
                    
                    // if frequency of value at ith index has become 0, then remove it.
                    if(map.get(arr[i]) == 0){
                        map.remove(arr[i]);
                    }
                    i++;
                }
                
                // if map size < current subarray length( means there is any duplicate element in current window
                // and  window is <= k, then return true.
                if((map.size() < j-i+1) && (j-i  <= k)){
                  
                    return true;
                }
                j++;
            }
            
        }
        
        return false;
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }
            int k = Integer.parseInt(br.readLine());
            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            boolean res = obj.checkDuplicatesWithinK(arr, k);
            if (res)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends