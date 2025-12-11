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

    //TABULATION
    public int uniquePathsWithObstacles(int[][] arr) {
         int n=arr.length, m=arr[0].length;
         
         // if start or destination is blocked, no paths
        if (arr[0][0] == 1 || arr[n-1][m-1] == 1) return 0;

       
        if(arr[n-1][m-1]==1) return 0;// if obstacle is on the destination, directly return 0;
        dp=new int[n][m];

        dp[0][0]=1; //starting is 1

        for(int i=1; i<m; i++)
        {
            if(dp[0][i-1]==1 && arr[0][i]!=1) //if previous col cell has 1 and grid doesn't have obstacle on current cell
            {
                dp[0][i]=1; // put 1 in current col, means there is way
            }
        }

         for(int i=1; i<n; i++)
        {
            if(dp[i-1][0]==1 && arr[i][0]!=1) 
            {
                dp[i][0]=1; // put 1 in current col, means there is way
            }
        }



        for(int i=1; i<n; i++)
        {
            for(int j=1; j<m; j++)
            {
                if(arr[i][j]==1) continue; //if current cell has obstacle , skip no need to calculate for it

                int top=dp[i-1][j];
                int left=dp[i][j-1];

                dp[i][j]=top+left;
            }
        }
        
        return dp[n-1][m-1];
    }
}
