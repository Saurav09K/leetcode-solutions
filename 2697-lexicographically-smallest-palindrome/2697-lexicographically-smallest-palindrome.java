class Solution {
    public String makeSmallestPalindrome(String s) {
        int i=0,j=s.length()-1;
        StringBuilder sb = new StringBuilder(s);
        while(i<j)
        {
            char left=sb.charAt(i);
            char right=sb.charAt(j);
            if(left!=right)
            {
                if(left>right)
                {
                    sb.setCharAt(i,right);
                }
                else if(left<right)
                {
                    sb.setCharAt(j,left);
                }
            }
            i++;
            j--;
        }
        return sb.toString();
    }
}