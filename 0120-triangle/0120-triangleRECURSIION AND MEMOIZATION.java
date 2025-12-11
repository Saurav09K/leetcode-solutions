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
    public int minimumTotal(List<List<Integer>> triangle) {
        int size=triangle.size();
        dp=new Integer[size][size];

        for(Integer a[]: dp)
        {
            Arrays.fill(a,null);
        }
        return f(triangle,0,0,triangle.size());
    }
}
