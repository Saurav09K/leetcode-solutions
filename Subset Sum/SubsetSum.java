class Solution {
    
    // ---------------------------------------------------
    // 1. RECURSIVE SOLUTION
    // ---------------------------------------------------
    static boolean f(int arr[], int target, int n) {
        // Base Case: If target is 0, we found a subset!
        if (target == 0) {
            return true;
        }
        // Base Case: No elements left
        if (n == 0) {
            // Check if the single element left equals the target
            return arr[0] == target;
        }

        // Logic: Take or Not Take
        boolean take = false;
        if (arr[n] <= target) {
            take = f(arr, target - arr[n], n - 1);
        }
        boolean notTake = f(arr, target, n - 1);

        return take || notTake;
    }

    // ---------------------------------------------------
    // 2. TABULATION SOLUTION (Iterative)
    // ---------------------------------------------------
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // --- Initialization (Base Cases) ---
        
        // 1. If target is 0 (first column), answer is ALWAYS TRUE (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // 2. If array is empty (first row), answer is FALSE (unless target is 0, handled above)
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        // --- Filling the Table ---
        for (int i = 1; i <= n; i++) {
            // 'j' represents the CURRENT TARGET we are trying to solve for
            for (int j = 1; j <= sum; j++) {
                
                boolean take = false;
                // FIX: Check if item fits in CURRENT target 'j', not total 'sum'
                if (arr[i - 1] <= j) {
                    take = dp[i - 1][j - arr[i - 1]];
                }
                
                // FIX: Use 'j' here as well
                boolean notTake = dp[i - 1][j];

                dp[i][j] = take || notTake;
            }
        }

        return dp[n][sum];
    }
}
