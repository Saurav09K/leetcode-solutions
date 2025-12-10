RECURSION//////////////////////////////////////////
class Solution {
    public int f(int i,int j)
    {
        
        if(i==0 && j==0) return 1; // 1 path found
        if(i<0 || j<0) return 0;   // out of bound check condition

        int up=f(i-1,j);          // go up
        int left=f(i,j-1);        // go left

        return up+left;           // total paths
    }
    public int uniquePaths(int m, int n) {
        return f(m-1,n-1);
    }
}


TABULATION/////////////////////////////////////////////////
class Solution {
    int dp[][];
    public int f(int i,int j)
    {
        
        if(i==0 && j==0) return 1; // 1 path found
        if(i<0 || j<0) return 0;   // out of bound check condition

        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        int up=f(i-1,j);          // go up
        int left=f(i,j-1);        // go left

        return dp[i][j]= up+left;           // total paths
    }
    public int uniquePaths(int m, int n) {
         dp=new int[m][n];

        for(int a[]: dp)
        {
            Arrays.fill(a,-1);
        }
        return f(m-1,n-1);
    }
}
