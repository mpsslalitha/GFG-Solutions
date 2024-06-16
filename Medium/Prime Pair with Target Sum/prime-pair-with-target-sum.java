//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends


// import java.util.ArrayList;

class Solution {
    
    static boolean isPrime(int n){
        if(n<2)
        return false;
        if(n==2||n==3)
        return true;
        if(n%2==0||n%3==0)
        return false;
        for(int i=5;i*i<=n;i=i+6){
            if(n%i==0||n%(i+2)==0)
            return false;
        }
        return true;
    } 
    
    
    public static ArrayList<Integer> getPrimes(int n) {
        // code here
        ArrayList<Integer>arr=new ArrayList<>();
        for(int i=2;i<=n/2;i++){
            if(isPrime(i)&&isPrime(n-i)){
                arr.add(i);
                arr.add(n-i);
                return arr;
            }
        }
        arr.add(-1);
        arr.add(-1);
        return arr;
        
        
        
    }
}