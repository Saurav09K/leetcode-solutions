class Solution {
    int dp[];
    public int f(int[] arr, int i, int target) {
        if (i == arr.length - 1) return 0;
        
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        int maxJump = Integer.MIN_VALUE;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j]-arr[i]>=-target && arr[j]-arr[i]<=target)
            {
                int jump = 1 + f(arr, j, target);
                maxJump = Math.max(maxJump,jump);
            }
        }
        return  dp[i] = maxJump;
    }
    public int maximumJumps(int[] nums, int target) {
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        int ans =  f(nums, 0, target);
       
        if(ans<0)
        {
            return -1;
        }
        else
        {
            return ans;
        }
    }
}