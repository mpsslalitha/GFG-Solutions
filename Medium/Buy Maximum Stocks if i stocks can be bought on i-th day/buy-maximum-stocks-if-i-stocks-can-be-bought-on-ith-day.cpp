//{ Driver Code Starts
/* Driver program to test above function */

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    int buyMaximumProducts(int n, int k, int price[]){
        //Write your code here
        vector< pair <int,int> > temp;
        for(int i=0;i<n;i++){
            temp.push_back({price[i],i+1});
        }
        sort(temp.begin(),temp.end());
        int count=0;
        for(int i=0;i<n;i++){
            if(temp[i].first*temp[i].second<=k){
               count+=temp[i].second;
               k-=temp[i].first*temp[i].second;
            }
              else if(floor(k/temp[i].first)){
                  count+=floor(k/temp[i].first);
                  k-=floor(k/temp[i].first)*temp[i].first;
              }
        }
        return count;
    }
};


//{ Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n, k;
	    cin >> n >> k;
	    int price[n];
	    for(int i = 0 ; i < n; i++){
	        cin >> price[i];
	    }
	    Solution ob;
	    int ans = ob.buyMaximumProducts(n, k, price);
	    cout << ans<<endl;
	}
	return 0;
}

// } Driver Code Ends