class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];

        for(int i=0; i<m; i++)
        {
            dp[i][0]=1; //fill 0th row with 1,s as only a single path to reach destination  
        }

        for(int i=0; i<n; i++)
        {
            dp[0][i]=1;  // fill 0th col with 1,s as only a single path to reach destination
        }

        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                int up=dp[i-1][j];
                int left=dp[i][j-1];

                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1]; //answer at the last index
    }
}
