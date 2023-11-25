//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	
	
	
	public:
	const int mx = 1e4;
    void shuffleArray(int arr[],int n)
    {
        int start = 1,end = n/2;
        for(int i=1;i<n;i++){
            if((i&1)==1){//odd
                arr[i] = (arr[end++] % mx)* mx + (arr[i] % mx);
            }else{
                arr[i] = (arr[start++] % mx)* mx + (arr[i] % mx);
            }
        }
        for(int i=1;i<n;++i)
            arr[i] /= mx;
    }
		 

};

//{ Driver Code Starts.


int main() 
{
   
   
   	int t;
    cin >> t;
    while (t--)
    {
    	int n;
	    cin>>n;
	    int a[n] ;
	    for(int i=0;i<n;i++)
	    {
	        cin>>a[i];
	    }


       

        Solution ob;
        ob.shuffleArray(a, n);

		for (int i = 0; i < n; i++) 
			cout << a[i] << " ";
    
	
        
	    cout << "\n";
	     
    }
    return 0;
}
// } Driver Code Ends