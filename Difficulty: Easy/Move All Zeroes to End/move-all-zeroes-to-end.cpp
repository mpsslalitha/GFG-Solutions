//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:
    void pushZerosToEnd(vector<int>& arr) {
        // code here
        queue <int> q;
        int count =0;
        for(int i=0;i<arr.size();i++){
        if(arr[i]!=0){
            q.push(arr[i]);
        }
       else{
            count++;
        }
        
      }
      for(int j=0;j<count;j++){
            q.push(0);
        }
         for (int i = 0; i < arr.size(); i++) {
            arr[i] = q.front();
            q.pop();
        }
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
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution ob;
        int n = arr.size();
        ob.pushZerosToEnd(arr);
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends