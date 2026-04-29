class Solution {
    Integer dp[]=new Integer[10001];
    int MOD = 1000000007;
    public int f(int n)
    {
        if(n==0) return 1;
        if(n==1) return 1;
        if(n==2) return 2;

        if(dp[n]!=null)
        {
            return dp[n];
        }
        long ans = (long)2 * f(n-1) + f(n-3);
        return dp[n] = (int)(ans%MOD);
    }
    public int numTilings(int n) {
        return f(n);
    }
}