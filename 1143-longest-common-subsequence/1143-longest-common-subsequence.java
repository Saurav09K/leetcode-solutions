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
        
        for(int arr[]:dp)
        {
            Arrays.fill(arr,-1);
        }

        return f(text1,text2,m,n);

       
    }
}