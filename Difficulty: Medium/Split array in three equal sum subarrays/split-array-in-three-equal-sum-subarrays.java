//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(int[] arr) {
        // code here
         int sum=0;
          List<Integer> list=new ArrayList<>(Arrays.asList(-1,-1));
          int first=-1;
          int last=-1;
          for(int i:arr){
               sum+=i; 
          }
          
          if(sum % 3 !=0){
               return list;
          }
          
          int target=sum/3;
          int curr=0;
          for(int i=0;i<arr.length;i++){
               curr+=arr[i];
               if(curr==target && first==-1){
                    first=i;
               }
               else if(curr==2*target && first!=-1){
                     last=i;
                     list.set(0,first);
                     list.set(1,last);
                     return list;
               }
          }
          
          return list;
    }
}