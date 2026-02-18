class Solution {
    public String dTob(int n)
    {
        StringBuilder sb = new StringBuilder();

        while(n>0)
        {
            int r = n%2;
            sb.append(r);
            n=n/2;
        }
        return sb.toString();
    }
    public boolean hasAlternatingBits(int n) {
        String binary = dTob(n);

        for(int i=1; i<binary.length(); i++)
        {
            if(binary.charAt(i)==binary.charAt(i-1))
            {
                return false;
            }
        }
        return true;
    }
}