//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution {
  public:
    vector<int> findTwoElement(vector<int>& arr) {
        // code he
          int n = arr.size();
        int xor_all = 0;
        // Step 1: XOR all numbers from 1 to n and all elements in arr
        for (int i = 0; i < n; i++) {
            xor_all ^= arr[i];
            xor_all ^= (i + 1);
        }
        // Step 2: Find the rightmost set bit in xor_all
        int right_set_bit = xor_all & -xor_all;
        // Step 3: Divide elements into two sets and XOR them
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] & right_set_bit)
                x ^= arr[i];
            else
                y ^= arr[i];
            
            if ((i + 1) & right_set_bit)
                x ^= (i + 1);
            else
                y ^= (i + 1);
        }
        // Step 4: Identify which is missing and which is repeating
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == x)
                count++;
        }
        
        if (count == 2)
            return {x, y};
        return {y, x};
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> a(n);
        for (int i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        auto ans = ob.findTwoElement(a);
        cout << ans[0] << " " << ans[1] << "\n";
    }
    return 0;
}
// } Driver Code Ends