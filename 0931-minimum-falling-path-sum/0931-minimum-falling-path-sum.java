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

    // TABULATION
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;

        dp=new Integer[n][m];

        // initialize only the first row 
        for(int i=0; i<m; i++)
        {
            dp[0][i]=matrix[0][i];
        }

        //looping from the 2nd row
        for(int i=1; i<n; i++)
        {
            //0 to m
            for(int j=0; j<m; j++)
            {
               
                int up=dp[i-1][j];
                int left=(int)1e9;
                int right=(int)1e9;
                if(j>0)
                {
                    left=dp[i-1][j-1];
                }
                if(j<m-1)
                {
                    right=dp[i-1][j+1];
                } 
                
                

                dp[i][j]=matrix[i][j]+Math.min(up,Math.min(left,right));
            }
        }
        int answer=Integer.MAX_VALUE;
        //search minimum answer from the last row
        for(int i=0; i<m; i++)
        {
            answer=Math.min(dp[n-1][i],answer);
        }
        return answer;
    }
}