//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	bool sameFreq(string s)
    {
         vector<int> arr(26);
        
        for(int i=0;i<s.size();i++) arr[s[i]-'a']++;
        int mini=s.size(),maxi=0;
        
        for(int i:arr)
        {
            if(i!=0){
            mini=min(mini,i);
            maxi=max(maxi,i);
            }
        }
        
        int count=0;
        for(int i:arr) if(i==maxi) count++;
        
        if(maxi!=mini && mini!=1)
        if(count>1) return false;
        
        return (maxi-mini)<=1?true:false;
    }


};

//{ Driver Code Starts.
int main(){
    int t;
    cin>>t;
    while(t--)
    {
        string s;
        cin>>s;
        Solution ob;
        cout<<ob.sameFreq(s)<<endl;
    }
}



// } Driver Code Ends