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

        if(target<-1000 || target>1000) // to handle the negative target as per the problem 
        {
            return 0;
        }
        
        int offset=1000+target; // to handle negative indexes for memoization(-1000 <= target <= 1000) otherwise OutOfBound Error

        if(dp[n][offset]!=-1)
        {
            return dp[n][offset];
        }

        int plus=f(arr,n-1,target+arr[n-1]);  //plus number and call
        int minus=f(arr,n-1,target-arr[n-1]); // minus and call

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


/*
Since the problem constraints say the sum of elements will never exceed 1000, the possible range of sums is -1000 to +1000.

Total numbers from -1000 to +1000 is 2001.

So, [n+1][2001] is the perfect size to hold every possible outcome.

The "Universal Shift" (Simplifying your logic)
Now that you have a size of 2001, you can ditch that complicated if(target < 0) logic entirely.

Think of it like this: Index 1000 in your array is your new "Zero".

If your current target is -5, store it at 1000 + (-5) = 995.

If your current target is +5, store it at 1000 + (5) = 1005.

*/
