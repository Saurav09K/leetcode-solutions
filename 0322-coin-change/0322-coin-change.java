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

        for(int i=0; i<=n; i++)
        {
            dp[i][0]=0; // if target amount 0, then coins need 0
        }

        for(int i=1; i<=m; i++)
        {
            if(i%coins[0]==0)
            {
                dp[1][i]=i/coins[0];
            }
            else
            {
                dp[1][i]=(int)1e9;
            }
        }

        for(int i=2; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                int take=(int)1e9;
                if(coins[i-1]<=j)
                {
                    take=1+dp[i][j-coins[i-1]];
                }
                int notTake=dp[i-1][j];

                dp[i][j]=Math.min(take,notTake);
            }
        }

        

         if(dp[n][m] >= (int)1e9) 
         {
                return -1;
         }
            return dp[n][m];


        // int ans= f(coins,amount,coins.length);
        // if(ans>=(int)1e9)
        // {
        //     return -1;
        // }
        // return ans;
    }
}