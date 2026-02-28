# 1680. Concatenation of Consecutive Binary Numbers

**Difficulty:** Medium  
**Tags:** Math, Bit Manipulation, Java

## 💡 Intuition & Logic

The brute-force approach of converting numbers to binary strings and concatenating them fails due to **Time Limit Exceeded (TLE)** and **Memory Overflow**. For a large `n` (like 100,000), the resulting binary string will be millions of characters long, which cannot be parsed back into a standard integer type.

Instead of strings, we must use **Mathematical Bit Shifting**. 
To append a new binary number `i` to our existing `ans`, we need to make space for it. We do this by Left Shifting (`<<`) our `ans` by the exact number of bits that `i` requires, and then adding (or using Bitwise OR `|`) the number `i` to it.

*Example:* If `ans = 1` and we want to append `2` (binary `10`, length 2):
Shift `ans` by 2 places: `1 << 2 = 100` (4 in decimal)
Add `2`: `100 | 10 = 110` (6 in decimal, which is the concatenation of `1` and `10`).

## 🚀 Approach 1: The Bitwise Trick (Optimal Logic)

The bit-length of numbers only increases when we hit a **Power of 2** (1, 2, 4, 8, 16...). We can track this using the famous bitwise trick `(i & (i - 1)) == 0`, which is only true for powers of 2.

```java
class Solution {
    public int concatenatedBinary(int n) {
        long MOD = 1_000_000_007;
        long ans = 0;
        int len = 0; // Tracks the bit length of the current number

        for (int i = 1; i <= n; i++) {
            // Increment length only when 'i' is a power of 2
            if ((i & (i - 1)) == 0) {
                len++;
            }
            // Left shift ans by 'len' bits, append 'i', and apply modulo
            ans = ((ans << len) | i) % MOD;
        }
        return (int) ans;
    }
}


Instead of manually tracking when the bit length increases, we can dynamically calculate the length of every number using Java's built-in Integer.numberOfLeadingZeros(i).
Since a Java int is 32 bits, subtracting the leading zeros gives us the exact number of bits currently in use.

class Solution {
    public int concatenatedBinary(int n) {
        long MOD = 1_000_000_007;
        long ans = 0;
        
        for (int i = 1; i <= n; i++) {
            int len = 32 - Integer.numberOfLeadingZeros(i);
            ans = ((ans << len) | i) % MOD;
        }
        return (int) ans;
    }
}


⏳ Complexity Analysis (For Both Approaches)
Time Complexity: O(N). We iterate from 1 to n exactly once. The bitwise operations and inbuilt functions run in constant O(1) time.

Space Complexity: O(1). We are only using a few variables (ans, len, MOD) regardless of the size of n. No strings or arrays are created.
