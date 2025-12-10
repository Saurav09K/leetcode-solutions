class Solution {
    public int rob(int[] nums) {

        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);


        int dp[]=new int[nums.length];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);//if two elements then put max of(a[0],a[1])
       
        for(int i=2; i<nums.length; i++)
        {
            int take=nums[i]+dp[i-2]; //take the item and n-2 
            int skip=dp[i-1];// skip current and take n-1

            dp[i]=Math.max(take,skip);
        }
        
        return dp[nums.length-1];
    }
}
