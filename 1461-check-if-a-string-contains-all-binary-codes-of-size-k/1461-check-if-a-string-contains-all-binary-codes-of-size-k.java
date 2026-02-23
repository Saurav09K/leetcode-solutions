class Solution {
    public boolean hasAllCodes(String s, int k) {
        int i=0,j=0;
        int n=s.length();

        Set<String> set = new HashSet<>();
        while(j<n)
        {
            while(j-i+1>k)
            {
                i++;
            }
            if(j-i+1==k)
            {
                String str = s.substring(i,j+1);
                set.add(str);
            }
            j++;
        }
        int x = (int)Math.pow(2,k);
        if(set.size()==x)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}