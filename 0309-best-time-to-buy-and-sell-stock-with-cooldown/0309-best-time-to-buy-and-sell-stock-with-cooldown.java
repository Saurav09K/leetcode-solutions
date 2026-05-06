class Solution {
    Integer dp[][][];
    public int f(int arr[],int i,boolean canBuy,boolean cooldown)
    {
        if(i==arr.length) return 0;

        int buyState = canBuy? 1 : 0;
        int cooldownState = cooldown? 1 : 0;

        if(dp[i][buyState][cooldownState]!=null)
        {
            return dp[i][buyState][cooldownState];
        }

        if(canBuy==true && cooldown==false)
        {
            int buy=-arr[i]+f(arr,i+1,false,cooldown);
            int skip=f(arr,i+1,true,cooldown);
            return dp[i][buyState][cooldownState] = Math.max(buy,skip);
        }
        else if(canBuy==false && cooldown==false)
        {
            int sell=arr[i]+f(arr,i+1,true,true);
            int hold=f(arr,i+1,false,false);
            return dp[i][buyState][cooldownState] = Math.max(sell,hold);
        }
        else
        {
            return dp[i][buyState][cooldownState] = f(arr,i+1,true,false);
        }
    }
    public int maxProfit(int[] prices) {
        dp=new Integer[prices.length][2][2];
        return f(prices,0,true,false);
    }
}