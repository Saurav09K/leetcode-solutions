class Solution {
    Integer dp[];
    public int f(int arr[],int i)
    {
        if(i>=arr.length)
        {
            return 0;
        }
        if(dp[i]!=null)
        {
            return dp[i];
        }
        int take = arr[i] + f(arr,i+2);
        int notTake = f(arr,i+1);

        return dp[i] = Math.max(take,notTake);
    }
    public int deleteAndEarn(int[] arr) {
        int points[] = new int[10001];
        dp = new Integer[10001];
        for(int nums: arr)
        {
            points[nums] = points[nums] + nums;
        }
        return f(points,0);
    }
}