class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        String middle = "";

        for (int i = 0; i < 26; i++) {

            // Add half of the characters
            for (int j = 0; j < freq[i] / 2; j++) {
                sb.append((char) (i + 'a'));
            }
            
            // Save the odd character (if any)
            if (freq[i] % 2 != 0) {
                middle = String.valueOf((char) (i + 'a'));
            }
        }
        
        String left = sb.toString();
        String right = sb.reverse().toString();
        
        return left + middle + right;
    }
}