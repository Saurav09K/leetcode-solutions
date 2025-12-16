class Solution {
    public int helper(String s,int i,int j)  // <----------functionn expands at the center of the string
    {
        int count=0;
      
        while(i>=0 && j<s.length())
        {
            if(s.charAt(i)==s.charAt(j))
            {
                count++;      //  <---------count is it palindrome or not
            }
            else
            {
                return count;
            }
            i--;  <-------expand to left
            j++;  <-------expand to right
        }
        return count;
    }
    public int countSubstrings(String s) {

        int totalCount=0;

        for(int i=0; i<s.length(); i++)
        {
            int x=helper(s,i,i);   //call for odd length, middle one is center
            int y=helper(s,i,i+1); //call for even length, two middle center's

            totalCount=totalCount+x+y; //add total count
            
        }
        return totalCount;
    }
}
