class Solution {
    int dp[][];
    public int f(int coins[],int amount,int n)
    {
        if(n==1) //only 1 coin is left
        {
            if(amount%coins[0]==0) //completely divides
            {
                return amount/coins[0];
            }
            else //not divides completely so cannot make that amount
            {
                return (int)1e9;
            }
        }

        if(dp[n][amount]!=-1)
        {
            return dp[n][amount];
        }
        int take=(int)1e9;
        if(coins[n-1]<=amount)
        {
            take=1+f(coins,amount-coins[n-1],n);
        }
        int notTake=f(coins,amount,n-1);

        return dp[n][amount]=Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int m=amount;
        dp=new int[n+1][m+1];

        for(int a[]: dp)
        {
            Arrays.fill(a,-1);
        }

        int ans= f(coins,amount,coins.length);
        if(ans>=(int)1e9)
        {
            return -1;
        }
        return ans;
    }
}