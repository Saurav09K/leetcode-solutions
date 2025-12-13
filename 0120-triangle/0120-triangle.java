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