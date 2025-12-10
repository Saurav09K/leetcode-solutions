class Solution {
    int f(int arr[],int n,int dp[])
    {
        if(n==0) return arr[0];
        if(n==1) return Math.max(arr[0],arr[1]);
        
        
        if(dp[n]!=-1) return dp[n];


        int take=arr[n]+f(arr,n-2,dp);
        int skip=f(arr,n-1,dp);

        return dp[n]= Math.max(take,skip);
    }
    public int rob(int[] nums) {
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return f(nums,nums.length-1,dp);
        
    }
}