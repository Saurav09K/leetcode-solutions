class Solution {
    Boolean dp[][];
    public boolean SubsetSum(int arr[],int target,int n)
    {
        if(target==0) return true;
        if(n==0) return false;

        if(dp[n-1][target]!=null)
        {
            return dp[n-1][target];
        }
        boolean take=false;
        if(arr[n-1]<=target)
        {
            take=SubsetSum(arr,target-arr[n-1],n-1);
        }
        boolean notTake=SubsetSum(arr,target,n-1);

        return dp[n-1][target]= take || notTake;
    }
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int totalSum=0;
        
        for(int a: arr)
        {
            totalSum=totalSum+a;
        }

        if(totalSum%2==1) return false;

        dp=new Boolean[n][(totalSum/2)+1];// extra size of +1 because if sum is 10, then we need dp[n][10] so to access 10 we need +1 size otherwise we will have 0 to 9 only.


        return SubsetSum(arr,totalSum/2,n);
    }
}