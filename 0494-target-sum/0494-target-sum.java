class Solution {
    int dp[][];
    public int f(int arr[],int n,int target)
    {
        if(n==0)
        {
            if(target==2*target)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }

        if(target<-1000 || target>1000)
        {
            return 0;
        }
        
        int offset=1000+target; // to handle negative indexes for memoization(-1000 <= target <= 1000)

        if(dp[n][offset]!=-1)
        {
            return dp[n][offset];
        }

        int plus=f(arr,n-1,target+arr[n-1]);
        int minus=f(arr,n-1,target-arr[n-1]);

        return dp[n][offset] = plus + minus;

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        dp=new int[n+1][1000*2+1];

        for(int a[]: dp)
        {
            Arrays.fill(a,-1);
        }
        return f(nums,n,target);
    }
}