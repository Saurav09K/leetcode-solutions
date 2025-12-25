class Solution {
    Integer dp[][];
    public int f(int arr[],int i,int prev)
    {
        if(i==arr.length)
        {
            return 0;
        }
        if(prev!=-1 && dp[i][prev]!=null)
        {
            return dp[i][prev];
        }
        int take=0;
        if(prev==-1 || arr[i]>arr[prev])
        {
            take=1+f(arr,i+1,i);
        }
        int skip=f(arr,i+1,prev);
        if(prev!=-1)
        {
            return dp[i][prev] = Math.max(take,skip);
        }
        else
        {
            return Math.max(take,skip);
        }
    }
    public int lengthOfLIS(int[] nums) {
        dp=new Integer[nums.length+1][nums.length+1];

        for(Integer a[]: dp)
        {
            Arrays.fill(a,null);
        }
        
        return f(nums,0,-1);
    }
}