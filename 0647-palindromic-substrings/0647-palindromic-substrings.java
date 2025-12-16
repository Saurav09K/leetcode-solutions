class Solution {
    /**
     * Problem: Count Palindromic Substrings
     * Approach: Dynamic Programming (Bottom-Up)
     * * Logic:
     * A substring s[i...j] is a palindrome if:
     * 1. The characters at the ends match: s.charAt(i) == s.charAt(j)
     * 2. The substring *inside* the ends (s[i+1...j-1]) is also a palindrome.
     * * We use a 2D boolean array 'dp' where dp[i][j] is true if the substring from i to j is a palindrome.
     * We iterate backwards for 'i' (start index) to ensure that when we check the "inside" (i+1),
     * that value has already been computed.
     */
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // dp[i][j] stores if s[i...j] is a palindrome
        int count = 0;

        // Outer Loop: 'i' is the START index.
        // We move BACKWARDS (n-1 down to 0) because to calculate dp[i][j],
        // we need the result of dp[i+1][j-1] (the inner substring).
        // By going backwards, we ensure row i+1 is computed before row i.
        for (int i = n - 1; i >= 0; i--) {
            
            // Inner Loop: 'j' is the END index.
            // A substring must end at or after it starts, so j starts at i.
            for (int j = i; j < n; j++) {
                
                // Step 1: Check if the characters at the ends match.
                // If they don't match, it can't be a palindrome.
                if (s.charAt(i) == s.charAt(j)) {
                    
                    // Step 2: Check the "inner" part.
                    // Condition A: (j-i+1 <= 2)
                    //    - If length is 1 ("a"), it's always a palindrome.
                    //    - If length is 2 ("aa"), we only needed the ends to match (which we checked above).
                    // Condition B: dp[i+1][j-1]
                    //    - If length > 2 ("cabac"), we check if the inner part "aba" (dp[i+1][j-1]) is true.
                    if ( (j - i + 1) <= 2 || dp[i + 1][j - 1] ) {
                        dp[i][j] = true;
                        count++; // Found a valid palindrome, increment count.
                    }
                }
            }
        }
        
        return count;
    }
}
