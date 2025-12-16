class Solution {
    Integer dp[][];
    public int f(int arr[][],int i,int j,int n,int m)
    {
        if(i<0 || j>=m || j<0)
        {
            return (int)1e9;
        }
        if(i==0)
        {
            return arr[i][j];
        }

        if(dp[i][j]!=null)
        {
            return dp[i][j];
        }

        int up=f(arr,i-1,j,n,m);
        int left=f(arr,i-1,j-1,n,m);
        int right=f(arr,i-1,j+1,n,m);

        return dp[i][j]=arr[i][j]+Math.min(up,Math.min(left,right));

    }
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        dp=new Integer[n][m];

        for(Integer a[]: dp)
        {
            Arrays.fill(a,null);
        }

        int minAns=Integer.MAX_VALUE;

        for(int i=0; i<m; i++)
        {
            int result=f(matrix,n-1,i,n,m);

            if(result<minAns)
            {
                minAns=result;
            }
        }
        return minAns;
    }
}