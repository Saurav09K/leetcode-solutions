class Solution {
    public int lastStoneWeightII(int[] arr) {
         int n=arr.length;
        int totalSum=0;

        for(int a: arr)
        {
            totalSum=totalSum+a;
        }
        Boolean dp[][]=new Boolean[n+1][totalSum+1];

        
        ///////////////////////////// base case initialization
        for(int i=0; i<=totalSum; i++)
        {
            dp[0][i]=false;
        }
        for(int i=0; i<=n; i++)
        {
            dp[i][0]=true;
        }
        //////////////////////////

        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=totalSum; j++)
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

        int min=Integer.MAX_VALUE;
        for(int i=0; i<=totalSum/2; i++)//can loop backward and if found first just break
        {
            if(dp[n][i]==true)
            {
                int subset_1=i;
                int subset_2=totalSum-subset_1;

                min=Math.min(min,Math.abs(subset_1-subset_2));
            }
        }
        return min;
    }
}
//same as minimum difference subset sum