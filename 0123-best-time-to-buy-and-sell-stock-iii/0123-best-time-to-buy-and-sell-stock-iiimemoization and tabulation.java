class Solution {
    Integer dp[][][];
    public int f(int arr[],int i, boolean canBuy,int transaction)
    {
        if(i==arr.length) return 0;

        if(transaction==0) return 0;

        int buyState = canBuy==true? 1 : 0;

        if(dp[i][buyState][transaction]!=null)
        {
            return dp[i][buyState][transaction];
        }

        if(canBuy)
        {
            int buy=-arr[i] + f(arr,i+1,false,transaction);
            int skip=f(arr,i+1,true,transaction);

            return dp[i][buyState][transaction] = Math.max(buy,skip);
        }
        else
        {
            int sell=arr[i] + f(arr,i+1,true,transaction-1);
            int hold=f(arr,i+1,false,transaction);

            return dp[i][buyState][transaction] = Math.max(sell,hold);
        }
    }
    public int maxProfit(int[] prices) {

        int dp[][][] = new int[prices.length+1][2][3];

        dp[prices.length][1][0]=0;

        for(int i=prices.length-1; i>=0; i--)
        {
           for(int buyState=0; buyState<=1; buyState++)
           {
               for(int transaction=1; transaction<=2; transaction++)
               {
                    if(buyState==1)
                    {
                        int buy=-prices[i] + dp[i+1][0][transaction];
                        int skip=dp[i+1][1][transaction];

                        dp[i][buyState][transaction] = Math.max(buy,skip); 
                    }
                    else
                    {
                        int sell = prices[i] + dp[i + 1][1][transaction - 1]; 
                        int hold = 0 + dp[i + 1][0][transaction];
                        
                        dp[i][buyState][transaction] = Math.max(sell, hold);
                    }
               }
           }
        }
        // The final answer bubbles all the way up to Day 0, able to buy (1), with 2 transactions.
        return dp[0][1][2];
    }
}
