class Solution {
    public int helper(String s,int i,int j)
    {
        int count=0;
      
        while(i>=0 && j<s.length())
        {
            if(s.charAt(i)==s.charAt(j))
            {
                count++;
            }
            else
            {
                return count;
            }
            i--;
            j++;
        }
        return count;
    }
    public int countSubstrings(String s) {

        int totalCount=0;

        for(int i=0; i<s.length(); i++)
        {
            int x=helper(s,i,i);
            int y=helper(s,i,i+1);

            totalCount=totalCount+x+y;
            
        }
        return totalCount;
    }
}
