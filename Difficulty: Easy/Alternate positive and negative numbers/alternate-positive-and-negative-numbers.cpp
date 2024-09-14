//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    void rearrange(vector<int> &arr) {
        vector<int> p , n; // Vectors to hold positive and negative numbers
        for(auto it : arr) {
            if(it >= 0) p.push_back(it); // Add positive numbers to vector p
            else n.push_back(it); // Add negative numbers to vector n
        }
        
        int i = 0 , j = 0; // Indexes for positive and negative vectors
        vector<int> ans; // Vector to hold the final rearranged array
        while (i < p.size() && j < n.size()) {
            ans.push_back(p[i++]); // Add positive number
            ans.push_back(n[j++]); // Add negative number
        }

        // Add remaining positive numbers, if any
        while (i < p.size()) {
            ans.push_back(p[i++]);
        }

        // Add remaining negative numbers, if any
        while (j < n.size()) {
            ans.push_back(n[j++]);
        }

        arr = ans; // Update the original array with the rearranged array
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        int num;

        getline(cin, input);
        stringstream s2(input);
        while (s2 >> num) {
            arr.push_back(num);
        }
        Solution ob;
        ob.rearrange(arr);
        for (int i = 0; i < arr.size(); i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends