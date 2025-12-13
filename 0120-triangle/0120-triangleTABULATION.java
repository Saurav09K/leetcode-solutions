class Solution {
    Integer dp[][];
    public int f(List<List<Integer>> arr,int i,int j,int n)
    {
        if(i==n)
        {
            return 0;
        }
        
        if(dp[i][j]!=null)
        {
            return dp[i][j];
        }
        
        return dp[i][j]=arr.get(i).get(j)+Math.min(f(arr,i+1,j,n),f(arr,i+1,j+1,n));
    }

   //////////////////////////////////////////////////////////////TABULATION/////////////////////////////////////////////////////////////////////////////////////
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        dp=new Integer[n][n];

        for(int j=0; j<n; j++) //                 <-------------------------base case initialization
        {
            dp[n-1][j]=triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--) //             <-------------------------loop over n-2 because n-1 is the base case initialization row,
        {
            for(int j=0; j<triangle.get(i).size(); j++)//               <---------------- j from 0 to list of ith row size 
            {
                dp[i][j]=triangle.get(i).get(j)+Math.min(dp[i+1][j],dp[i+1][j+1]); //       <--------------------- if list[i][j] condition from recursion
            }
        }
        return dp[0][0];
    }
}
