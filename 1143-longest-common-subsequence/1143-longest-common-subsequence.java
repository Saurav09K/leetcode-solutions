class Solution {
    int dp[][];
    public int f(String a,String b,int m,int n)
    {
        if(m==0 || n==0) return 0;

        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }
        if(a.charAt(m-1)==b.charAt(n-1))
        {
            return dp[m][n]= 1+f(a,b,m-1,n-1);
        }
        else
        {
            return dp[m][n]= Math.max(f(a,b,m,n-1),f(a,b,m-1,n));
        }
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        dp=new int[m+1][n+1];
        
        // for(int arr[]:dp)
        // {
        //     Arrays.fill(arr,-1);
        // }

        // tabulation

        for(int i=0; i<=n; i++)
        {
            dp[0][i]=0;
        }
        for(int i=0; i<=m; i++)
        {
            dp[i][0]=0;
        }

        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}