import java.util.Arrays;

class Solution {
    int dp[][];

    public int f(int coins[], int amount, int n) {
        // Base Case: Only 1 coin left (index 0)
        if (n == 1) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            } else {
                return (int) 1e9;
            }
        }

        // Memoization Check
        if (dp[n][amount] != -1) {
            return dp[n][amount];
        }

        // Logic
        int take = (int) 1e9;
        if (coins[n - 1] <= amount) {
            // Infinite supply: stay at index 'n'
            take = 1 + f(coins, amount - coins[n - 1], n);
        }
        
        int notTake = f(coins, amount, n - 1);

        return dp[n][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        // 1. Initialize DP Array FIRST (Size n+1 to handle index 'n')
        dp = new int[n + 1][amount + 1];
        
        // 2. Fill with -1
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // 3. Call Recursion
        int ans = f(coins, amount, n);

        // 4. Check for "Infinity" (No solution found)
        if (ans >= (int) 1e9) {
            return -1;
        }
        return ans;
    }
}
