class Solution {
    int dp[][];
    public int f(int val[],int wt[],int capacity,int n)
    {
        if(capacity==0)
        {
            return 0;
        }
        if(n==1)
        {
            return (capacity/wt[0]) * val[0];
        }
        
        int take=Integer.MIN_VALUE;
        if(wt[n-1]<=capacity)
        {
            take=val[n-1]+f(val,wt,capacity-wt[n-1],n);
        }
        int notTake=f(val,wt,capacity,n-1);
        
        return Math.max(take,notTake);
    }

  
  //////////////////////////////////////////////////////////////////////TABULATION/////////////////////////////////////////////////////////////////////////////////////
    public int knapSack(int val[], int wt[], int capacity) {
        int n=val.length;
        
        dp=new int[n+1][capacity+1];

       //zero capacity, 0 profit (col 0) (base case)
        for(int i=0; i<=n; i++)
        {
            dp[i][0]=0;
        }
      //fill row 1, and store the profit for each weight (base case)
        for(int i=1; i<=capacity; i++)
        {
            int profit=(i / wt[0]) * val[0];
            
            dp[1][i]=profit; // first row
        }
        
        for(int i=2; i<=n; i++)
        {
            for(int j=1; j<=capacity; j++)
            {
                int take=Integer.MIN_VALUE;
                if(wt[i-1]<=j)
                {
                   take=val[i-1]+dp[i][j-wt[i-1]]; 
                }
                int notTake=dp[i-1][j];
                
                dp[i][j]=Math.max(take,notTake);
            }
        }
        
        return dp[n][capacity];
        
    }
}
