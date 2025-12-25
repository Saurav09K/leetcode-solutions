class Solution {
    public int lengthOfLIS(int[] arr) {
        int dp[]=new int[arr.length];

        Arrays.fill(dp,1);

        for(int i=0; i<arr.length; i++)
        {
            for(int j=0; j<=i; j++)
            {
                if(arr[i]>arr[j])
                {
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int a: dp)
        {
            max=Math.max(max,a);
        }
        return max;
    }
}