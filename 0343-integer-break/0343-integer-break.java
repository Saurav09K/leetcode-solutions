class Solution {
    int dp[];
    public int f(int n)
    {
        if(n==1) return 1;

        if(dp[n]!=-1)
        {
            return dp[n];
        }

        int max=Integer.MIN_VALUE;
        for(int i=1; i<n; i++)
        {
            // either i*(n-1) is bigger or i* f(n-1);
            int product= i * Math.max(n-i,f(n-i));
            
            max=Math.max(product,max);
            dp[n]=max;
        }
        return max;

    }
    public int integerBreak(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return f(n);
    }
}