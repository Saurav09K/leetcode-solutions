import java.util.Arrays;

class Solution {
    int dp[][];

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        // Size [n+1][amount+1]
        // Rows: 0 to n (Where Row 'i' means considering first 'i' coins)
        // Cols: 0 to amount
        dp = new int[n + 1][amount + 1];

        // --- STEP 1: INITIALIZATION (Base Cases) ---
        
        // A. If Target Amount is 0, we need 0 coins.
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }

        // B. Initialize Row 1 (Using ONLY the 1st coin -> coins[0])
        // We do this manually because Row 1 depends on Row 0 (Empty), which is useless here.
        // We act like the recursion stopped at n=1.
        for (int j = 1; j <= amount; j++) {
            if (j % coins[0] == 0) {
                // If amount is divisible, we take (amount / value) coins
                dp[1][j] = j / coins[0];
            } else {
                // If not divisible, it's impossible to make this amount with just this coin
                dp[1][j] = (int) 1e9;
            }
        }

        // --- STEP 2: MAIN LOOPS ---
        // Start from Row 2 (considering 2nd coin) since Row 1 is already done.
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                
                // Option 1: Not Take (Skip this coin)
                // Look at the previous row (i-1) for the same amount
                int notTake = dp[i - 1][j];
                
                // Option 2: Take (Use this coin)
                int take = (int) 1e9;
                if (coins[i - 1] <= j) {
                    // CRITICAL LOGIC: Infinite Supply
                    // We stay in the CURRENT ROW (i) because we can use this coin again!
                    // taking 1 coin + result for remaining amount
                    take = 1 + dp[i][j - coins[i - 1]];
                }

                // Store the minimum of both choices
                dp[i][j] = Math.min(take, notTake);
            }
        }

        // --- STEP 3: FINAL CHECK ---
        // If the answer is >= 1e9, it means we never found a valid solution.
        if (dp[n][amount] >= (int) 1e9) {
            return -1;
        }
        
        return dp[n][amount];
    }
}
