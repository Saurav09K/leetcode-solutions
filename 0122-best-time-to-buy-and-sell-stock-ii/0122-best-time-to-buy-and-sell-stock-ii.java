class Solution {
    // Initialize 2D array: [number of days][2 boolean states]
    Integer[][] dp;

    public int f(int arr[], int i, boolean canBuy) {
        if (i == arr.length) return 0;

        int buyState = canBuy ? 1 : 0;

        if (dp[i][buyState] != null) {
            return dp[i][buyState];
        }
        
        if (canBuy) {
            // Choice A: Buy today, sell tomorrow, cannot buy tomorrow
            int buy = -arr[i] + f(arr, i + 1, false);
            
            // Choice B: Don't buy today, buy tomorrow
            int skip = f(arr, i + 1, true);
            
            return dp[i][buyState] = Math.max(buy, skip);
        } else {
            // Choice A: Sell today and buy tomorrow another stock
            int sell = arr[i] + f(arr, i + 1, true);
            
            // Choice B: Hold today then sell tomorrow
            int hold = f(arr, i + 1, false);
            
            return dp[i][buyState] = Math.max(sell, hold);
        }
    }
    
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length][2];
        return f(prices, 0, true);
    }
}