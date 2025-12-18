class Solution {
    int dp[][];
    public int f(int coins[],int amount,int n)
    {
        if(amount==0)
        {
            return 1;
        }
        if(n==1) 
        {
            if(amount%coins[0]==0) 
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        if(dp[n][amount]!=-1)
        {
            return dp[n][amount];
        }

        int take=0;
        if(coins[n-1]<=amount)
        {
            take=f(coins,amount-coins[n-1],n);
           
        }
        int notTake=f(coins,amount,n-1);

        return dp[n][amount]= take+notTake;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;

        dp=new int[n+1][amount+1];

        for(int a[]: dp)
        {
            Arrays.fill(a,-1);
        }
         return f(coins,amount,n);
    }
}