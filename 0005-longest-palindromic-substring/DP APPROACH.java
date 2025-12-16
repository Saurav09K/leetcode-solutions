class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // The Table
        int maxLen = 0;
        int start = 0;

        // Same BACKWARDS loop structure
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                
                // Same Logic: Ends match AND (small length OR inner is valid)
                if (s.charAt(i) == s.charAt(j)) {
                    if ((j - i + 1) <= 2 || dp[i + 1][j - 1]) {
                        
                        dp[i][j] = true; // Mark as palindrome

                        // --- CHANGE IS HERE ---
                        // Instead of count++, we check for max length
                        if (j - i + 1 > maxLen) {
                            maxLen = j - i + 1;
                            start = i;
                        }
                        // ----------------------
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }
}
