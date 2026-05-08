<div align="center">
  <h1>🚀 Decode Ways: DP Optimization Journey</h1>
  <p><i>A deep dive into optimizing Memoization from high object overhead to pure O(N)</i></p>
</div>

<hr>

<h2>💡 The Golden Rule: Counting vs. Generating</h2>
<blockquote>
  <strong>If the problem asks "How many ways?", it is a Counting problem (DP). We don't care <em>what</em> the decoded strings look like, only <em>if</em> the jumps are mathematically valid.</strong><br><br>
  Generating actual strings (like building <code>"A"</code>, <code>"B"</code>) is for Backtracking when an interviewer asks to return all possible combinations.
</blockquote>

<h2>🐌 Approach 1: The "Simulation Trap" (Unoptimized)</h2>
<p>The initial instinct is to simulate the decoding using substrings and HashMaps. While logically correct, it has major performance bottlenecks:</p>
<ul>
  <li>🔴 <strong>Heavy String Operations:</strong> <code>s.substring()</code> creates a new object in memory on every call, turning an <code>O(1)</code> state transition into an <code>O(N)</code> operation.</li>
  <li>🔴 <strong>HashMap Overhead:</strong> Using <code>HashMap&lt;String, Integer&gt;</code> is overkill when the only changing state is the integer <code>index</code>.</li>
  <li>🔴 <strong>Unnecessary Loops:</strong> Looping through the rest of the string is wasteful since valid jumps can only be 1 or 2 characters long.</li>
</ul>

<details>
  <summary><b>Click to view optimized Logic</b></summary>
  <h2>⚡ Approach 2: Pure State DP (Optimized)</h2>
<p>Instead of looping and building strings, we branch exactly two ways: take 1 character, or take 2 characters.</p>

<h3>Two Ways to Check 2-Digit Validity:</h3>

<h4>1️⃣ The Math Approach</h4>
<p>Extract the integer value mathematically to avoid string parsing overhead.</p>
<pre><code>
int twoDigitValue = (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0');
if (twoDigitValue >= 10 && twoDigitValue <= 26) {
    count += f(s, index + 2, dp);
}
</code></pre>

<h4>2️⃣ The Character Boundary Approach</h4>
<p>Check the character limits directly. This is cleaner to read and entirely avoids integer conversions.</p>
<pre><code>
char first = s.charAt(index);
char second = s.charAt(index + 1);

// Valid if it starts with '1' (10-19) OR starts with '2' and ends in '0'-'6' (20-26)
if (first == '1' || (first == '2' && second >= '0' && second <= '6')) {
    count += f(s, index + 2, dp);
}
</code></pre>

<details open>
  <summary><b>Click to view Full Optimized O(N) Code</b></summary>

```java
class Solution {
    public int numDecodings(String s) {
        // Integer array for memoization (null means uncomputed)
        Integer[] dp = new Integer[s.length()];
        return f(s, 0, dp);
    }

    private int f(String s, int index, Integer[] dp) {
        if (index == s.length()) return 1;
        if (s.charAt(index) == '0') return 0;
        if (dp[index] != null) return dp[index];

        // Option 1: Take 1 character
        int count = f(s, index + 1, dp);

        // Option 2: Take 2 characters (Character boundary check)
        if (index + 1 < s.length()) {
            char first = s.charAt(index);
            char second = s.charAt(index + 1);
            
            if (first == '1' || (first == '2' && second >= '0' && second <= '6')) {
                count += f(s, index + 2, dp);
            }
        }
        return dp[index] = count;
    }
}
