class Solution {
    public int concatenatedBinary(int n) {
        long MOD = 1_000_000_007;
        long ans = 0;
        
        for (int i = 1; i <= n; i++) {
            // Har number 'i' ke liye uski exact bit length find
            int len = 32 - Integer.numberOfLeadingZeros(i);
            ans = ((ans << len) | i) % MOD;
        }
        
        return (int) ans;
    }
}