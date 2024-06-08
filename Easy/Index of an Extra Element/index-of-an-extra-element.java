//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    public int findExtra(int n, int arr1[], int arr2[]) {
        // add code here.
         int xor = 0;
        for (int i = 0; i < arr1.length; i++) {
            xor ^= arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            xor ^= arr2[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == xor) {
                return i;
            }
        }
        
        return arr1.length;
    }
}