class Solution {
    public int minimumRecolors(String blocks, int k) {
        int i=0,j=0,n=blocks.length();
        int count=0;
        int min=Integer.MAX_VALUE;
        while(j<n)
        {
            if(blocks.charAt(j)=='W')
            {
                count++;
            }
               
                if(j-i+1==k)
                {
                    min=Math.min(min,count);
                    if(blocks.charAt(i)=='W')
                    {
                        count--;
                    }
                    i++;
                }
            j++;

        }
        return min;
    }
}