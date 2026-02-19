class Solution {
    public int countBinarySubstrings(String s) {
        
        int currGroup=1;
        int prevGroup=0;
        int count=0;
        for(int i=1; i<s.length(); i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
            {
                currGroup++;
            }
            else
            {
                prevGroup=currGroup;
                currGroup=1;
            }

            if (prevGroup >= currGroup) 
            {
                 count++;
            }

        }
        return count;
    }
}