Delete and Earn - Data Transformation & DPThis README documents the approach, common traps, and core concepts for solving the Delete and Earn problem. The biggest takeaway from this problem is learning to transform the input data to simplify the rules of the game before applying Dynamic Programming.1. The Core Problem & The TrapsThe rules state: If you take nums[i], you earn its points, but you must delete all copies of nums[i] - 1 and nums[i] + 1.Trying to run a recursive "Take or Not Take" function on the raw, unsorted array leads to two massive traps:The Amnesia Trap: If you take a 4 early in the array, you have to delete all 3s and 5s. If you don't sort or restructure the array, your recursive function will eventually stumble upon a 3 later on and "forget" that it was supposed to be deleted globally.The Duplicates Trap: If the array has [3, 3, 3], picking the first 3 deletes 2s and 4s, but the other 3s are perfectly safe! You want to take all of them as a "package deal" for 9 points. Processing them one by one is inefficient and messy.2. The "Aha!" Moment: The Frequency ArrayInstead of writing complex while loops to group duplicates and skip adjacent values, we can completely eliminate the problem by transforming the data into a Frequency Array (or Points Array).Given the constraint that nums[i] maxes out at 10,000, we create a new array of size 10001:Javaint[] points = new int[10001];
for(int num : nums) {
    points[num] += num; // Sums up all duplicates into one package
}
Why this is magic:Auto-Grouping: All copies of 3 are summed up at points[3].Auto-Sorting: The indices themselves represent the numbers in perfect order.Rule Simplification: The complex "delete num - 1 and num + 1" rule is now just: "You cannot pick adjacent indices in the points array." (This turns the problem into the classic House Robber DP pattern).3. The Recursive Engine (Take vs. Not Take)Now, we just iterate through our new points array with a simple choice at index i:Take it: We get the points at i, but we must skip the adjacent number. Move to i + 2.Not Take it: We get 0 points, but we are free to look at the very next number. Move to i + 1.Javaint take = points[i] + f(points, i + 2);
int notTake = 0 + f(points, i + 1);
return Math.max(take, notTake);
4. The TLE Reality Check & MemoizationEven though the points array is only size 10,000, pure recursion will trigger a Time Limit Exceeded (TLE) error.Why? Because the recursion tree splits into two branches (i + 1 and i + 2) on every single call. This creates overlapping subproblems and explodes into an exponential time complexity of $O(2^n)$. For an array of size 10,000, the number of calculations is astronomically high.The Fix: Add a 1D Cache (Integer[] dp).By caching the answer for a specific index the very first time we calculate it, we snip off the duplicate branches of the tree. This drops the time complexity from an impossible $O(2^n)$ down to a lightning-fast $O(n)$.5. The Constraint Trap (Off-by-One)Always read the max constraints! The problem states 1 <= nums[i] <= 10^4 (10,000).If you initialize your frequency array as new int[10000], it only goes up to index 9999. When the test case contains the number 10000, the code will throw an IndexOutOfBoundsException.Always size the array to Max_Value + 1 (e.g., new int[10001]).Final Optimized Code OutlineJavaclass Solution {
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
}
