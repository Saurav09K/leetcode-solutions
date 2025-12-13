class Solution {
    Integer dp[];

    // public int f(List<List<Integer>> arr,int i,int j,int n)
    // {
    //     if(i==n)
    //     {
    //         return 0;
    //     }
        
    //     if(dp[i][j]!=null)
    //     {
    //         return dp[i][j];
    //     }
        
    //     return dp[i][j]=arr.get(i).get(j)+Math.min(f(arr,i+1,j,n),f(arr,i+1,j+1,n));
    // }

    //Tabulation
    istead of a 2d dp array use a 1d dp array, because we only want one row answer and previous rows answers are not needed to compute further , initialize the
    dp with base case and overrite it with new answers and return dp[0] at last as the final answer.
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        dp=new Integer[n];

        for(int j=0; j<n; j++) // base case initialization
        {
            dp[j]=triangle.get(n-1).get(j);
        }

        for(int i=n-2; i>=0; i--)
        {
            for(int j=0; j<triangle.get(i).size(); j++)
            {
                dp[j]=triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}
