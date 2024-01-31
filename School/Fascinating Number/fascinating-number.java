//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution ob = new Solution();

        int T = sc.nextInt();

        while (T != 0) {
            long n = sc.nextLong();
            if (ob.fascinating(n))
                System.out.println("Fascinating");
            else
                System.out.println("Not Fascinating");
            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    boolean fascinating(long n) {
        // code here
        String sum = "";
        if (n > 2) {
            sum = String.valueOf(n*2) + String.valueOf(n*3) + String.valueOf(n);
        }

        if (sum.length() < 9) return false;
        
        for (int i = 1; i <= sum.length(); i++) {
            if (!sum.contains(String.valueOf(i))) return false;
        }
        
        return true;
    }
}