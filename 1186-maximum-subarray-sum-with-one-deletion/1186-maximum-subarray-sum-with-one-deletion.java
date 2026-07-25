class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
    
    // Arrays for our 2 states
    int[] p1 = new int[n]; // No deletion
    int[] p2 = new int[n]; // One deletion
    
    // Base cases
    p1[0] = arr[0];
    p2[0] = -100_000_000; // Impossible to delete an element if the subarray is size 1
    
    int maxSum = arr[0]; 

    for (int i = 1; i < n; i++) {
        // State 1: Normal line
        p1[i] = Math.max(p1[i-1] + arr[i], arr[i]);
        
        // State 2: Superpower used (Delete today OR extend a past deletion)
        p2[i] = Math.max(p1[i-1], p2[i-1] + arr[i]);
        
        // The problem says "at most one" deletion, so both states are valid answers
        maxSum = Math.max(maxSum, Math.max(p1[i], p2[i]));
    }
    
    return maxSum;
    }
}