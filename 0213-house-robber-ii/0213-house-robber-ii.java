class Solution {
    int f(int arr[],int n,int dp[])
    {
        if(n==0) return arr[0];
        if(n==1) return Math.max(arr[0],arr[1]);
        
        
        if(dp[n]!=-1) return dp[n];
        int left=arr[n]+f(arr,n-2,dp);
        int right=f(arr,n-1,dp);

        return dp[n]= Math.max(left,right);
    }
    public int rob(int[] nums) {
        if(nums.length==1)return nums[0];
        if(nums.length==1) return Math.max(nums[0],nums[1]);
        int dp[]=new int[nums.length];
       
        int numsCopy[]=new int[nums.length-1];//extra array copy nums value from 1th index to last in this dp2, then call on this array 
         int dp3[]=new int[numsCopy.length];
        for(int i=0; i<numsCopy.length; i++)
        {
            numsCopy[i]=nums[i+1];
        }
        Arrays.fill(dp,-1);
         Arrays.fill(dp3,-1);

        int x= f(nums,nums.length-2,dp);//call 0 to n-2
        int y=f(numsCopy,numsCopy.length-1,dp3);//call 1 to n-1
        
        return Math.max(x,y);
        
    }
}
// f(arr, 0, n-2)
// f(arr, 1, n-1)
// or another way is to add an start index on function and pass start and ending index for better 