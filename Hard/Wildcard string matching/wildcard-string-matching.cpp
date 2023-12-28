//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function template for C++
class Solution{
    public:
    int dp[1001][1001];
    int solve(string p, string s, int i, int j) {
    if (i == -1 && j == -1) {
        return 1;
    }
    if (j == -1) {
        for (int k = 0; k <i; k++)
        {
            if (p[k] != '*') 
            {
                return 0;
            }
        }
        return 1;
    }
    if (i == -1) {
        return 0;
    }
    if (dp[i][j] != -1) {
        return dp[i][j];
    }

    if (p[i] == '?' || p[i] == s[j]) { 
        return dp[i][j] = solve(p, s, i - 1, j - 1);
    }
    if (p[i] == '*') { 
        int op1 = solve(p, s, i - 1, j);
        int op2 = solve(p, s, i, j - 1);
        return dp[i][j] = (op1 | op2);
    }
    return dp[i][j] = 0;
}

bool match(string wild, string pattern) {
    int n = wild.size();
    int m = pattern.size();
    memset(dp,-1,sizeof(dp));
    return solve(wild, pattern, n - 1, m - 1);
}
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t-->0)
    {
        string wild, pattern;
        cin>>wild>>pattern;
        
        Solution ob;
        bool x=ob.match(wild, pattern);
        if(x)
        cout<<"Yes\n";
        else
        cout<<"No\n";
    }
    return 0;
}
// } Driver Code Ends