class Solution {
    int dp[][];
    public int f(String word1,String word2,int m,int n)
    {
        if(m==0 || n==0) return 0;

        if(dp[m][n]!=-1)
        {
            return dp[m][n];
        }

        if(word1.charAt(m-1) == word2.charAt(n-1))
        {
            return dp[m][n] = 1 + f(word1,word2,m-1,n-1);
        }
        else
        {
            return dp[m][n] = Math.max(f(word1,word2,m-1,n),f(word1,word2,m,n-1));
        }
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length(); 
        int n=word2.length();

        dp=new int[m+1][n+1];

        for(int a[] : dp)
        {
            Arrays.fill(a,-1);
        }

        int LCS=f(word1,word2,m,n);

        return (m-LCS) + (n-LCS);

    }
}