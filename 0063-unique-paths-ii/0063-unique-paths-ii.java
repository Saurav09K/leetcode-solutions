class Solution {
    int dp[][];
    int f(int arr[][],int n,int m,int i,int j)
    {
        
        if(i==n-1 && j==m-1 && arr[i][j]==0 ) return 1;
        if(i>=n || j>=m) return 0;
        if(arr[i][j]==1) return 0;
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }

        int left=f(arr,n,m,i,j+1);
        int right=f(arr,n,m,i+1,j);
        return dp[i][j]= left+right;

    }
    public int uniquePathsWithObstacles(int[][] arr) {
        int n=arr.length, m=arr[0].length;
        if(arr[n-1][m-1]==1) return 0;// if obstacle is on the destination, directly return 0;
        dp=new int[n][m];

        //fill wiht -1s
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
            {
                dp[i][j]=-1;
            }
        }
        return f(arr,n,m,0,0);
    }
}