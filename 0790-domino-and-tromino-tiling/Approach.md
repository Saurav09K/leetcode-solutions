<div align="center">
  <h1>🧱 LeetCode 790: Domino and Tromino Tiling</h1>
  <p><i>A complete breakdown from 2D State DP to an O(1) Mathematical Approach</i></p>
</div>

<hr>

<h2>🧠 The Core Concept</h2>
<p>
  At first glance, this looks like a complex geometry puzzle. But it's actually a classic <strong>Dynamic Programming (DP) State Machine</strong> problem. As we build a <code>2 x n</code> wall from left to right, the rightmost edge of our wall can only be in one of two states:
</p>
<ul>
  <li><strong>Flat (Perfect Wall):</strong> Both the top and bottom rows end at the exact same column.</li>
  <li><strong>Jagged (Imperfect Wall):</strong> One row sticks out exactly 1 block further than the other.</li>
</ul>

<hr>

<h2>🛠️ Approach 1: DP with States (Top-Down Memoization)</h2>
<p>
  We can think of this as having two different functions (or "factories"): one that strictly produces <strong>Flat</strong> walls, and one that strictly produces <strong>Jagged</strong> walls. They call each other to complete the puzzle.
</p>

<h3>The State Transitions:</h3>
<ul>
  <li>
    <code>flat(n) = flat(n-1) + flat(n-2) + 2 * jagged(n-1)</code><br>
    <em>Logic: Add 1 vertical, OR add 2 horizontals, OR add an L-shaped Tromino to a previously jagged wall (multiplied by 2 for top/bottom variants).</em>
  </li>
  <li>
    <code>jagged(n) = jagged(n-1) + flat(n-2)</code><br>
    <em>Logic: Extend a jagged wall with 1 horizontal domino, OR attach an L-shape to a perfectly flat wall to make it jagged.</em>
  </li>
</ul>

<h3>Java Implementation:</h3>
<pre><code class="language-java">
class Solution {
    Integer flatdp[] = new Integer[10001];
    Integer jaggeddp[] = new Integer[10001];
    int MOD = 1000000007;

    public int flat(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(flatdp[n] != null) return flatdp[n];
        
        // Using 'long' to prevent integer overflow before applying modulo
        long ans = (long)flat(n-1) + flat(n-2) + 2L * jagged(n-1);
        return flatdp[n] = (int)(ans % MOD);
    }

    public int jagged(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 0;
        if(n == 2) return 1;

        if(jaggeddp[n] != null) return jaggeddp[n];
        
        long ans = (long)jagged(n-1) + flat(n-2); 
        return jaggeddp[n] = (int)(ans % MOD);
    }

    public int numTilings(int n) {
        return flat(n); // We only want the perfectly flat wall at the end
    }
}
</code></pre>

<hr>

<h2>🚀 Approach 2: The Math Pattern (O(1) Space Optimization)</h2>
<p>
  If we manually draw out the first few valid configurations, we get a sequence: 
  <strong>1, 2, 5, 11, 24...</strong>
</p>
<p>
  By observing this sequence, we can extract a direct mathematical recurrence relation that completely removes the need for the <code>jagged</code> state. The number of ways to build a wall of length <i>i</i> depends only on lengths <i>i-1</i> and <i>i-3</i>:
</p>

<blockquote>
  $$dp[i] = 2 \times dp[i-1] + dp[i-3]$$
</blockquote>

<p>Because we only need to look back 3 steps at any given time, we can ditch the arrays entirely and use just 3 variables, reducing our Space Complexity from O(N) to <strong>O(1)</strong>.</p>

<h3>Fully Optimized Java Implementation:</h3>
<pre><code class="language-java">
class Solution {
    public int numTilings(int n) {
        int MOD = 1000000007;
        
        // Base cases directly handle small N
        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 5;
        
        // Variables to keep track of the last 3 states
        long dp_i_3 = 1; // Answer for n-3
        long dp_i_2 = 2; // Answer for n-2
        long dp_i_1 = 5; // Answer for n-1
        
        for (int i = 4; i <= n; i++) {
            // Apply the mathematical sequence formula
            long current_dp = (2 * dp_i_1 + dp_i_3) % MOD;
            
            // Shift variables forward for the next iteration
            dp_i_3 = dp_i_2;
            dp_i_2 = dp_i_1;
            dp_i_1 = current_dp;
        }
        
        return (int) dp_i_1;
    }
}
</code></pre>

<hr>

<h2>⚠️ Key Takeaways & Traps to Avoid</h2>
<ul>
  <li><strong>Integer Overflow:</strong> When the problem states <em>"return the answer modulo 10^9 + 7"</em>, always cast intermediate DP additions to <code>long</code>. If you add multiple <code>int</code> limits together, they will overflow into negative numbers before the modulo is applied.</li>
  <li><strong>Double Counting:</strong> In the DP state approach, adding two vertical dominoes to <code>flat(n-2)</code> is illegal because that configuration is already covered by adding one vertical domino to <code>flat(n-1)</code>. Always add pieces to the rightmost edge to ensure unique combinations.</li>
</ul>
