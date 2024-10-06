//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  
  public:
 int dir[8][2]={{0,1},{1,0},{-1,0},{0,-1},{-1,-1},{-1,1},{1,-1},{1,1}};
   
 void solve(vector<vector<char>>&grid,vector<vector<char>>&vis,int i,int j){
  
     int n=grid.size();
     int m=grid[0].size();
     
     vis[i][j]=1;
     
     queue<pair<int,int>>q;
     
     q.push({i,j});
     
     while(!q.empty()){
         
         
         int row=q.front().first;
         int col=q.front().second;
         
         q.pop();
         
         
         for(int i=0;i<8;i++){
             
             int nr=row+dir[i][0];
             
             int nc=col+dir[i][1];
             
             
             if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]=='0' && grid[nr][nc]=='1'){
                 
                 
                 vis[nr][nc]='1';
                 
                 q.push({nr,nc});
                 
             }
         }
     }
       
   }
   
    int numIslands(vector<vector<char>>& grid) {
    
    int n=grid.size();
    int m=grid[0].size();
    
    vector<vector<char>>vis(n,vector<char>(m,'0'));
    
    
    int cnt=0;
    
    for(int i=0;i<n;i++){
        
        for(int j=0;j<m;j++){
            
           if(vis[i][j]== '0' && grid[i][j]=='1'){
               
               
               solve(grid,vis,i,j);
               cnt++;
               
             
           }
        }
    }
    
    return cnt;
    
    
    }

};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, m;
        cin >> n >> m;
        vector<vector<char>> grid(n, vector<char>(m, '#'));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin >> grid[i][j];
            }
        }
        Solution obj;
        int ans = obj.numIslands(grid);
        cout << ans << '\n';
    }
    return 0;
}
// } Driver Code Ends