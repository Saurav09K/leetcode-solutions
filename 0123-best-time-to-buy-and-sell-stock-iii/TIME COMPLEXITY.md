<h2>🧠 Time & Space Complexity Analysis</h2>

<hr>

<h1>🚀 1. Memoization (Top-Down DP)</h1>

<h3>⏱️ Time Complexity: <code>O(N)</code></h3>

<h3>✅ Why?</h3>
<ul>
  <li>There are total unique states:</li>
</ul>

<pre><code>N × 2 × 3 = 6N
</code></pre>

<ul>
  <li>Due to memoization, each state is computed only once.</li>
  <li>Every computation inside the function takes <code>O(1)</code> time.</li>
</ul>

<pre><code>O(6N) → O(N)
</code></pre>

<hr>

<h3>💾 Space Complexity: <code>O(N)</code></h3>

<h3>✅ Why?</h3>

<p>We use memory for two things:</p>

<h4>1️⃣ DP Array</h4>

<pre><code>Integer[N][2][3]
</code></pre>

<p>Space used:</p>

<pre><code>O(N)
</code></pre>

<h4>2️⃣ Recursion Stack</h4>

<ul>
  <li>Recursive calls go day-by-day.</li>
  <li>Maximum recursion depth = <code>N</code></li>
</ul>

<p>Space used:</p>

<pre><code>O(N)
</code></pre>

<h4>📌 Total Space</h4>

<pre><code>O(N) + O(N) = O(N)
</code></pre>

<hr>

<h1>🚀 2. Tabulation (Bottom-Up DP)</h1>

<h3>⏱️ Time Complexity: <code>O(N)</code></h3>

<h3>✅ Why?</h3>

<p>We run 3 nested loops:</p>

<pre><code>N × 2 × 3 = 6N
</code></pre>

<p>After removing constants:</p>

<pre><code>O(6N) → O(N)
</code></pre>

<hr>

<h3>💾 Space Complexity: <code>O(N)</code></h3>

<h3>✅ Why?</h3>

<p>We use a DP table:</p>

<pre><code>int[N+1][2][3]
</code></pre>

<p>Its size grows linearly with <code>N</code>.</p>

<pre><code>O(N)
</code></pre>

<p>✅ No recursion stack is used here, so this is more memory-efficient practically than memoization.</p>

<hr>

<h1>👑 3. Space Optimized Tabulation</h1>

<h3>⏱️ Time Complexity: <code>O(N)</code></h3>

<h3>✅ Why?</h3>

<ul>
  <li>Still processing every day once.</li>
  <li>Same transitions as tabulation.</li>
</ul>

<pre><code>O(N)
</code></pre>

<hr>

<h3>💾 Space Complexity: <code>O(1)</code></h3>

<h3>✅ Why?</h3>

<ul>
  <li>Current day only depends on next day.</li>
  <li>No need to store all <code>N</code> days.</li>
</ul>

<p>We only keep:</p>

<pre><code>int[2][3] ahead
int[2][3] curr
</code></pre>

<p>Total stored values:</p>

<pre><code>2 × 3 + 2 × 3 = constant
</code></pre>

<p>Since memory does NOT grow with <code>N</code>:</p>

<pre><code>O(1)
</code></pre>

<hr>

<h1>📊 Final Complexity Comparison</h1>

<table border="1" cellpadding="8" cellspacing="0">
  <tr>
    <th>Approach</th>
    <th>Time Complexity</th>
    <th>Space Complexity</th>
  </tr>
  <tr>
    <td>Memoization</td>
    <td><code>O(N)</code></td>
    <td><code>O(N)</code></td>
  </tr>
  <tr>
    <td>Tabulation</td>
    <td><code>O(N)</code></td>
    <td><code>O(N)</code></td>
  </tr>
  <tr>
    <td>Space Optimized DP</td>
    <td><code>O(N)</code></td>
    <td><code>O(1)</code></td>
  </tr>
</table>

<br>

<p>🔥 <b>Best Approach:</b> Space Optimized Tabulation because it achieves:</p>

<pre><code>O(N) Time + O(1) Space
</code></pre>
