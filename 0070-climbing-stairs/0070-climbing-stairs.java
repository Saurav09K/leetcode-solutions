//recursive
class Solution {
    public int climbStairs(int n) {
        if(n==0) return 1;
        if(n==1) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}

//memoization
class Solution {
    public int climb(int n,int dp[])
    {
        if(n==0) return 1; // if there is no step then , cost to keep at that place is only one way
        if(n==1) return 1; // if only one step, then goin to that step only one way

       if(dp[n]!=-1)
       {
        return dp[n];
       }
        return dp[n]= climb(n-1,dp) + climb(n-2,dp);
    }
    public int climbStairs(int n) {
       int dp[]=new int[n+1];
      Arrays.fill(dp,-1);

      return climb(n,dp);
    }
}

Tabulation
    
