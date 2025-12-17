class Solution {
    // DP Array
    int dp[][];

    // ---------------------------------------------------------
    // RECURSIVE HELPER (For Reference / Logic Derivation)
    // ---------------------------------------------------------
    public int f(int arr[], int target, int n) {
        // Base Case: We have processed all elements (n=0)
        if (n == 0) {
            // If target is 0, we found 1 valid subset (the empty set).
            // If target is > 0, we found nothing.
            if (target == 0) return 1;
            else return 0;
        }
        
        // Option 1: Pick the number (if it fits)
        int take = 0;
        if (arr[n-1] <= target) {
            take = f(arr, target - arr[n-1], n - 1);
        }
        
        // Option 2: Don't pick the number
        int notTake = f(arr, target, n - 1);
        
        // Return total count of valid subsets found in both branches
        return take + notTake;
    }

    // ---------------------------------------------------------
    // MAIN TABULATION SOLUTION
    // ---------------------------------------------------------
    public int perfectSum(int[] arr, int target) {
        int n = arr.length;
        
        // dp[i][j] stores: "Number of subsets using first 'i' items that sum to 'j'"
        dp = new int[n + 1][target + 1];

        // --- STEP 1: INITIALIZATION (Base Cases) ---
        
        // Case A: If array is empty (Row 0), but Target > 0
        // Impossible to make sum > 0 with no elements. Count = 0.
        for (int i = 0; i <= target; i++) {
            dp[0][i] = 0;
        }

        // Case B: Target is 0 (Column 0)
        // Note: We initialize this to 1 because strictly speaking, for an empty set,
        // there is 1 way to make sum 0 (choose nothing).
        // HOWEVER: The inner loop (starting at j=0) will UPDATE this later for rows where
        // we encounter Zeros in the array (e.g., subset {0}).
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        // --- STEP 2: FILLING THE TABLE ---
        for (int i = 1; i <= n; i++) {
            
            // CRITICAL CHANGE: Start j from 0, not 1.
            // Why? Because if arr[i-1] is 0, we need to update the column j=0.
            // Example: If we have a '0', we can "Take" it (sum stays 0) or "Not Take" it (sum stays 0).
            // This turns the count from 1 -> 2. The loop calculates this automatically here.
            for (int j = 0; j <= target; j++) {
                
                int take = 0;
                // Check if current element fits in the current target 'j'
                if (arr[i-1] <= j) {
                    take = dp[i-1][j - arr[i-1]];
                }
                
                int notTake = dp[i-1][j];
                
                // Total ways = Ways if we Take + Ways if we Don't Take
                dp[i][j] = take + notTake;
            }
        }
        
        // Return the answer for all 'n' elements trying to reach 'target'
        return dp[n][target];
    }
}
