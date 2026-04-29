class Solution {
    Integer flatdp[]=new Integer[10001];
    Integer jaggeddp[]=new Integer[10001];
    int MOD = 1000000007;
    public int flat(int n)
    {
        if(n==0) return 1;
        if(n==1) return 1;
        if(n==2) return 2;

        if(flatdp[n]!=null)
        {
            return flatdp[n];
        }
        long ans = (long)flat(n-1) + flat(n-2) + 2*jagged(n-1);
        return flatdp[n] = (int)(ans%MOD);
    }
    public int jagged(int n)
    {
        if(n<=0) return 0;
        if(n==1) return 0;
        if(n==2) return 1;

        if(jaggeddp[n]!=null)
        {
            return jaggeddp[n];
        }
        long ans = (long)jagged(n-1) + flat(n-2);
        return jaggeddp[n] = (int)(ans%MOD);
    }
    public int numTilings(int n) {
        return flat(n);
    }
}