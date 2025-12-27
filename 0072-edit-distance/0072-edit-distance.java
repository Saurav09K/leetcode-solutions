class Solution {
    int dp[][];
    public int f(String s1,String s2, int m,int n)
    {
        if(m==0) return n; 
        if(n==0) return m;
        
        if(dp[m][n]!=-1)
        {
            return dp[m][n];

        }
        if(s1.charAt(m-1) == s2.charAt(n-1))
        {
            return dp[m][n] = f(s1,s2,m-1,n-1);
        }
        else
        {
            int insert = 1 + f(s1,s2,m,n-1);
            int delete = 1 +f(s1,s2,m-1,n);
            int replace = 1 +f(s1,s2,m-1,n-1);

            return dp[m][n] = Math.min(insert,Math.min(delete,replace));
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
        
        return f(word1,word2,m,n);
    }
}