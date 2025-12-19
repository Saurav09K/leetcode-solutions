class Solution {
    int dp[][];
    public int f(int coins[],int amount,int n)
    {
        if(amount==0) // if amount 0, one way is is found
        {
            return 1;
        }
        if(n==1)  // one coin left
        {
            if(amount%coins[0]==0) // check that amount is divisible by coin
            {
                return 1; // one way found
            }
            else
            {
                return 0; // cannot make up to target
            }
        }

        if(dp[n][amount]!=-1)
        {
            return dp[n][amount];
        }

        int take=0;
        if(coins[n-1]<=amount)
        {
            take=f(coins,amount-coins[n-1],n); // take the coin and call at the same coin
           
        }
        int notTake=f(coins,amount,n-1); // take another 

        return dp[n][amount]= take+notTake; // find total ways
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;

        dp=new int[n+1][amount+1];

        // for(int a[]: dp)
        // {
        //     Arrays.fill(a,-1);
        // }
        //  return f(coins,amount,n);

        for(int i=0; i<=n; i++) // initialize 0th column
        {
            dp[i][0]=1; // if target is zero, one way is form zero, empty set { }
        }
        for(int i=1; i<=amount; i++) // initialize the 1st row
        {
            if(i % coins[0] == 0) 
            {
                dp[1][i]=1;
            }
            else
            {
                dp[1][i]=0;
            }
        }

        for(int i=2; i<=n; i++)
        {
            for(int j=1; j<=amount; j++)
            {
                int take=0;
                if(coins[i-1]<=j)
                {
                    take=dp[i][j-coins[i-1]];
                }
                int notTake=dp[i-1][j];

                dp[i][j]=take+notTake;
            }
        }
        return dp[n][amount];
    }
}