class Solution {
    Integer dp[][];
    
    public int f(int arr[][],int i,int j,int n,int m)
    {
        if(i<0 || j>=m || j<0) // if i goes out of bound, if j goes out of bound to right, if j goes out of bound to the left
        {
            return (int)1e9; // safer than INT MAX because of integer overflow problem 
        }
        if(i==0) // if reached at the 0 th row simply return current [i][j]
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
            Arrays.fill(a,null);//negative values are already present in array thats why Integer is used with null initialization
        }

        int minAns=Integer.MAX_VALUE;

        for(int i=0; i<m; i++) // run a loop at low row for every cell
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
