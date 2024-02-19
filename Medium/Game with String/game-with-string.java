//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        int n =s.length();
        if(k>=n){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)-> y-x);
        for(char key:map.keySet()){
            pq.add(map.get(key));
        }
        while(k>0){
            Integer temp = pq.poll();
            temp--;
            pq.add(temp);
            k--;
        }
        int ans = 0;
        while(!pq.isEmpty()){
            int num = pq.poll();
            ans = ans+(num*num);
        }
        
        return ans;
    }
}