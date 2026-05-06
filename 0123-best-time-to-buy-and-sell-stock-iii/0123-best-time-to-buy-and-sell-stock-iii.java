class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        int[][] next = new int[2][3]; // Holds day i + 1
        int[][] curr = new int[2][3]; // Holds day i
        
        for (int i = n - 1; i >= 0; i--) {
            for (int buyState = 0; buyState <= 1; buyState++) {
                for (int trans = 1; trans <= 2; trans++) {
                    
                    if (buyState == 1) { 
                        int buy = -prices[i] + next[0][trans];
                        int skip = 0 + next[1][trans];
                        
                        curr[buyState][trans] = Math.max(buy, skip);
                        
                    } else { 
                        int sell = prices[i] + next[1][trans - 1]; 
                        int hold = 0 + next[0][trans];
                        
                        curr[buyState][trans] = Math.max(sell, hold);
                    }
                }
            }
            
            // THE TIME SHIFT: Today is over. 
            // Copy all of today's values into 'next' so they are ready for the next loop.
            for (int b = 0; b < 2; b++) {
                for (int t = 0; t < 3; t++) {
                    next[b][t] = curr[b][t];
                }
            }
        }
        
        // The final answer is in 'next' because the last time shift pushed Day 0 into 'next'
        return next[1][2];
    }
}