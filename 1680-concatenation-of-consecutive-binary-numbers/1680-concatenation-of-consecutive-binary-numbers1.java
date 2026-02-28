class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        int len=0;
        long ans=0;
        for(int i=1; i<=n; i++)
        {
            if((i & (i-1))==0)
            {
                len++;
            }
            ans=((ans<<len) | i) % MOD;
        }
        return (int)ans;
    }
}
