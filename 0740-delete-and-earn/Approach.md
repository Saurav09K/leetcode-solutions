<h1>Delete and Earn - Data Transformation & DP</h1>

<p>This README documents the approach, common traps, and core concepts for solving the <strong>Delete and Earn</strong> problem. The biggest takeaway from this problem is learning to <strong>transform the input data</strong> to simplify the rules of the game <em>before</em> applying Dynamic Programming.</p>

<hr>

<h2>1. The Core Problem & The Traps</h2>
<p>The rules state: If you take <code>nums[i]</code>, you earn its points, but you must delete all copies of <code>nums[i] - 1</code> and <code>nums[i] + 1</code>.</p>
<p>Trying to run a recursive "Take or Not Take" function on the raw, unsorted array leads to two massive traps:</p>
<ul>
    <li><strong>The Amnesia Trap:</strong> If you take a <code>4</code> early in the array, you have to delete all <code>3</code>s and <code>5</code>s. If you don't sort or restructure the array, your recursive function will eventually stumble upon a <code>3</code> later on and "forget" that it was supposed to be deleted globally.</li>
    <li><strong>The Duplicates Trap:</strong> If the array has <code>[3, 3, 3]</code>, picking the first <code>3</code> deletes <code>2</code>s and <code>4</code>s, but the other <code>3</code>s are perfectly safe! You want to take all of them as a "package deal" for 9 points. Processing them one by one is inefficient and messy.</li>
</ul>

<h2>2. The "Aha!" Moment: The Frequency Array</h2>
<p>Instead of writing complex <code>while</code> loops to group duplicates and skip adjacent values, we can completely eliminate the problem by transforming the data into a <strong>Frequency Array</strong> (or Points Array).</p>
<p>Given the constraint that <code>nums[i]</code> maxes out at 10,000, we create a new array of size <code>10001</code>:</p>

<pre><code>int[] points = new int[10001];
for(int num : nums) {
    points[num] += num; // Sums up all duplicates into one package
}</code></pre>

<p><strong>Why this is magic:</strong></p>
<ul>
    <li><strong>Auto-Grouping:</strong> All copies of <code>3</code> are summed up at <code>points[3]</code>.</li>
    <li><strong>Auto-Sorting:</strong> The indices themselves represent the numbers in perfect order.</li>
    <li><strong>Rule Simplification:</strong> The complex "delete <code>num - 1</code> and <code>num + 1</code>" rule is now just: <strong>"You cannot pick adjacent indices in the <code>points</code> array."</strong> (This turns the problem into the classic <em>House Robber</em> DP pattern).</li>
</ul>

<h2>3. The Recursive Engine (Take vs. Not Take)</h2>
<p>Now, we just iterate through our new <code>points</code> array with a simple choice at index <code>i</code>:</p>
<ul>
    <li><strong>Take it:</strong> We get the points at <code>i</code>, but we must skip the adjacent number. Move to <code>i + 2</code>.</li>
    <li><strong>Not Take it:</strong> We get 0 points, but we are free to look at the very next number. Move to <code>i + 1</code>.</li>
</ul>

<pre><code>int take = points[i] + f(points, i + 2);
int notTake = 0 + f(points, i + 1);
return Math.max(take, notTake);</code></pre>

<h2>4. The TLE Reality Check & Memoization</h2>
<p>Even though the <code>points</code> array is only size 10,000, pure recursion will trigger a <strong>Time Limit Exceeded (TLE)</strong> error.</p>
<p>Why? Because the recursion tree splits into two branches (<code>i + 1</code> and <code>i + 2</code>) on every single call. This creates overlapping subproblems and explodes into an exponential time complexity of $O(2^n)$. For an array of size 10,000, the number of calculations is astronomically high.</p>

<p><strong>The Fix:</strong> Add a 1D Cache (<code>Integer[] dp</code>).</p>
<p>By caching the answer for a specific index the very first time we calculate it, we snip off the duplicate branches of the tree. This drops the time complexity from an impossible $O(2^n)$ down to a lightning-fast $O(n)$.</p>

<h2>5. The Constraint Trap (Off-by-One)</h2>
<p>Always read the max constraints! The problem states <code>1 &lt;= nums[i] &lt;= 10^4</code> (10,000).</p>
<p>If you initialize your frequency array as <code>new int[10000]</code>, it only goes up to index <code>9999</code>. When the test case contains the number <code>10000</code>, the code will throw an <code>IndexOutOfBoundsException</code>.</p>
<ul>
    <li><strong>Always size the array to <code>Max_Value + 1</code></strong> (e.g., <code>new int[10001]</code>).</li>
</ul>

<h2>Final Optimized Code Outline</h2>
<pre><code>class Solution {
    Integer[] dp;
    
    public int f(int[] points, int i) {
        if (i >= points.length) return 0;
        
        if (dp[i] != null) return dp[i];
        
        int take = points[i] + f(points, i + 2);
        int notTake = f(points, i + 1);
        
        dp[i] = Math.max(take, notTake);
        return dp[i];
    }
    
    public int deleteAndEarn(int[] nums) {
        int[] points = new int[10001]; 
        dp = new Integer[10001];
        
        for (int num : nums) {
            points[num] += num;
        }
        
        return f(points, 0);
    }
}</code></pre>
