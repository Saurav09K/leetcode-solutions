class Solution {
    public long maxSubarraySumWithMultiply(int[] arr, long k) {
    int n = arr.length;
    
    long[] p1 = new long[n];
    long[] p2 = new long[n];
    long[] p3 = new long[n];
    
    p1[0] = arr[0];
    p2[0] = arr[0] * k;
    p3[0] = -1_000_000_000_000_000L; // Safe negative infinity (prevents underflow)
    
    long maxSum = Math.max(p2[0], p3[0]);
    
    for (int i = 1; i < n; i++) {
        // Phase 1: Standard Kadane's
        p1[i] = Math.max(arr[i], p1[i-1] + arr[i]);
        
        // Phase 2: Superpower Active (Extend p2, Start from p1, or Start fresh)
        p2[i] = Math.max(p2[i-1] + arr[i]*k, Math.max(p1[i-1] + arr[i]*k, arr[i]*k));
        
        // Phase 3: Superpower Finished (Turn off from p2, or Extend p3)
        p3[i] = Math.max(p2[i-1] + arr[i], p3[i-1] + arr[i]);
        
        // Update global max using ONLY valid states where superpower was used
        maxSum = Math.max(maxSum, Math.max(p2[i], p3[i]));
    }
    
    return maxSum;
}
public long maxSubarraySumWithDivide(int[] arr, long k) {
    int n = arr.length;
    long[] p1 = new long[n];
    long[] p2 = new long[n];
    long[] p3 = new long[n];
    
    p1[0] = arr[0];
    p2[0] = arr[0] / k; 
    p3[0] = -1_000_000_000_000_000L; 
    
    long maxSum = Math.max(p2[0], p3[0]);
    
    for (int i = 1; i < n; i++) {
        p1[i] = Math.max(arr[i], p1[i-1] + arr[i]);
        
        long div = arr[i] / k; 
        
        p2[i] = Math.max(p2[i-1] + div, Math.max(p1[i-1] + div, div));
        
        p3[i] = Math.max(p2[i-1] + arr[i], p3[i-1] + arr[i]);
        maxSum = Math.max(maxSum, Math.max(p2[i], p3[i]));
    }
    
    return maxSum;
}
    public long maxSubarraySum(int[] arr, int k) {
       long maxWithMultiply = maxSubarraySumWithMultiply(arr, k);
       long maxWithDivide = maxSubarraySumWithDivide(arr, k);
    
       return Math.max(maxWithMultiply, maxWithDivide);
    }
}