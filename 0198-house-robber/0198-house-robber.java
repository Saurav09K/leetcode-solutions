class Solution {
    public int rob(int[] nums) {

        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);


        int dp[]=new int[nums.length];

        int a=nums[0];
        int b=Math.max(nums[0],nums[1]);//if two elements then put max of(a[0],a[1])
       
        int c=0;
        for(int i=2; i<nums.length; i++)
        {
            int take=nums[i]+a; //take the item and n-2 
            int skip=b;// skip current and take n-1

            c=Math.max(take,skip);

            a=b;
            b=c;
        }
        
        return c;
    }
}