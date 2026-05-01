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
        dp=new Integer[prices.length][2][3];
        return f(prices,0,true,2);
    }
}