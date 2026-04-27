Decode Ways - Recursion & Memoization Concepts
This README serves as a personal breakdown of the core concepts, traps, and "Aha!" moments encountered while solving the Decode Ways problem using Recursion and Dynamic Programming (Memoization).

It is designed to be a quick refresher on how to approach string-partitioning problems.

1. The Core Mental Model: "Anchor and Scout"
When using a for loop inside a recursive function to slice a string into chunks, the loop variables act as an "Anchor" and a "Scout".

index (The Anchor): This is passed into the function. It marks exactly where the current chunk begins. It does not move while building the chunk.

i (The Scout): This is the loop variable (for (int i = index; ...)). It steps forward one character at a time, looking for a valid code (e.g., checking "2", then "22").

2. The i + 1 Breakthrough (Preventing Overlaps)
The most critical logic bug in string partitioning is passing the wrong index to the next recursive call.

The Scenario: Input is "226". The loop grabs "22" using indices 0 and 1.

❌ Why f(s, index + 1, n) fails: If the chunk started at index = 0, index + 1 tells the next call to start at index 1. But index 1 is the second '2', which was already consumed in "22". This causes overlapping counts and infinite loops.

✅ Why f(s, i + 1, n) works: Since i represents the end of the current chunk (index 1), passing i + 1 forces the next call to start safely at index 2 (the '6').

Rule of Thumb: Always step forward from the end of your last chunk (i + 1), not the beginning!

3. The break vs return 0 Logic
When building a string chunk, if it becomes invalid (e.g., "27" is not in the 1-26 map), the handling is crucial:

Do NOT return 0;: If you return 0, you instantly kill the function call and throw away the valid counts you successfully gathered in earlier loop iterations (like when checking just "2").

DO use break;: If "27" is invalid, longer strings like "273" will also definitely be invalid. Breaking out of the loop stops unnecessary checks, but safely allows the function to reach the bottom and return the count it has already built up.

4. Memoization (DP) Structure
Pure recursion causes a Time Limit Exceeded (TLE) error because it calculates overlapping branches exponentially. Memoization caches the results.

Moving Away from Global Variables
Memoization does not work with global counter variables. The function must ask, "How many ways from this specific index?" 1. Change the function return type to int.
2. Use a local int count = 0 inside the function.
3. Accumulate the results of recursive calls: count += f(...).
4. Return the local count at the end.

Interview Optimization: Array DP over Map DP
While using a Map<String, Integer> where the key is the remaining substring works conceptually, it is slow and eats up memory because it creates a brand new string on every single recursive call.

The Fix: The only thing actually changing between recursive calls is the starting index.
Therefore, an Integer[] dp array of size n (where the index itself is the key) is significantly faster and shows a better understanding of memory optimization for technical interviews.
