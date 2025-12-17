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

        int m=(totalSum/2);
        dp=new Boolean[n+1][m+1];// extra size of +1 because if sum is 10, then we need dp[n][10] so to access 10 we need +1 size otherwise we will have 0 to 9 only.


        for(int i=0; i<=m; i++)
        {
            dp[0][i]=false;
        }
        for(int i=0; i<=n; i++)
        {
            dp[i][0]=true;
        }

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                boolean take=false;
                if(arr[i-1]<=j)
                {
                    take=dp[i-1][j-arr[i-1]];
                }
                boolean notTake=dp[i-1][j];

                dp[i][j]=take || notTake;
            }
        }
        return dp[n][m];
    }
}