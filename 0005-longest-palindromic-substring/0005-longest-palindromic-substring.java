class Solution {
    public int helper(String s, int i, int j) {
        int length = 0; // Default length
        
        // Expand while characters match and are within bounds
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                length = j - i + 1; // Update length for this valid match
                i--; // Expand Left
                j++; // Expand Right
            } else {
                break; // Stop if mismatch
            }
        }
        return length;
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check both Odd (len1) and Even (len2) centers
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i + 1);
            
            // Get the best length found at this center
            int len = Math.max(len1, len2);

            // If this is the longest palindrome seen so far, update global max
            if (len > maxLen) {
                maxLen = len;
                // Calculate start index based on center 'i' and length 'len'
                start = i - (len - 1) / 2;
            }
        }
        
        return s.substring(start, start + maxLen);
    }
}
