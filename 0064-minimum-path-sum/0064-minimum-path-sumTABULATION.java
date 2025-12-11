class Solution {
    int dp[][];
    public int f(int grid[][],int m,int n)
    {
        if(m==0 && n==0) return grid[0][0];
        if(m<0 || n<0) return Integer.MAX_VALUE;

        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }

        int top=f(grid,m-1,n);
        int right=f(grid,m,n-1);

        return dp[m][n]=grid[m][n]+Math.min(top,right);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        dp=new int[m][n];

         dp[0][0] = grid[0][0]; //copy [0][0] cell to dp

        // first row (prefix sums)
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        // first column (prefix sums)
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }

        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                int top=dp[i-1][j];
                int right=dp[i][j-1];

                dp[i][j]=grid[i][j]+Math.min(top,right);
            }
        }

        return dp[m-1][n-1];
    }
}
