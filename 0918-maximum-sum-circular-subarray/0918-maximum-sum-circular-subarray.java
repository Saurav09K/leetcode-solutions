class Solution {
    public int maxSubarraySumCircular(int[] arr) {
        int totalSum=0;
        for(int a: arr)
        {
            totalSum=totalSum+a;
        }
        int minSum=Integer.MAX_VALUE;
        int maxSum=Integer.MIN_VALUE;
       
        int currSum=0;
        int currSum2=0;
        for(int a: arr)
        {
            currSum=Math.min(a,currSum+a); // <--calculate minimum subarray sum using kadane
            minSum=Math.min(minSum,currSum);    // <-

            currSum2=Math.max(a,currSum2+a); // <-- calculate maximum subarray sum using kadane
            maxSum=Math.max(maxSum,currSum2);// <-
        }
        if(maxSum<0) // if maxSum negative means all values are negative
        {
            return maxSum;
        }

        // either normal kadane is maximum or,,,,, total - minimum kadane is maximum
        int ans=Math.max(maxSum,totalSum-minSum);
        return ans;

        
    }
}