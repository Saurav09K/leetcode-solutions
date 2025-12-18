class Solution {
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
        int plus=f(arr,n-1,target+arr[n-1]);
        int minus=f(arr,n-1,target-arr[n-1]);

        return plus + minus;

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        return f(nums,n,target);
    }
}