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

        for(int a[]: dp)
        {
            Arrays.fill(a,-1);
        }
        return f(grid,m-1,n-1);
    }
}