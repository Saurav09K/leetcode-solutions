class Solution {
    Integer dp[][];
    public int f(int arr[],int i,boolean canBuy,int fees)
    {
        if(i==arr.length) return 0;

        int buyState = canBuy? 1 : 0;
        if(dp[i][buyState]!=null)
        {
            return dp[i][buyState];
        }
        if(canBuy)
        {
            int buy=-arr[i] + f(arr,i+1,false,fees)-fees;
            int skip=f(arr,i+1,true,fees);
            return dp[i][buyState] = Math.max(buy,skip);
        }
        else
        {
            int sell=arr[i] + f(arr,i+1,true,fees);
            int hold=f(arr,i+1,false,fees);
            return dp[i][buyState] = Math.max(sell,hold);
        }
    }
    public int maxProfit(int[] prices, int fee) {
        dp=new Integer[prices.length][2];
        return f(prices,0,true,fee);
    }
}