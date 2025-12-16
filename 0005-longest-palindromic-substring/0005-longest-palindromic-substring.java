class Solution {
    public int helper(String s, int i,int j)
    {
        int length=0;
        while(i>=0 && j<s.length())
        {
            if(s.charAt(i)==s.charAt(j))
            {
                length=j-i+1;
            }
            else
            {
                return length;
            }
            i--;
            j++;
        }
        return length;
    }
    public String longestPalindrome(String s) {
        int n=s.length();
        int max=0;
        int start=0;
        for(int i=0; i<n; i++)
        {
            int plength_1=helper(s,i,i);

            if(plength_1>max)
            {
                max=plength_1;
                start=start = i - (plength_1 - 1) / 2;

            }


            int plength_2=helper(s,i,i+1);
            if(plength_2>max)
            {
                max=plength_2;
                start=start = i - (plength_2 - 1) / 2;

            }
           
        }
         return s.substring(start,start+max);
    }
}