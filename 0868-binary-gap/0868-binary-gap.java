class Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n);
        int max=0;
        for(int i=0; i<binary.length(); i++)
        {
            char ch=binary.charAt(i);
            if(ch=='1')
            {
                int j=i+1;
                while(j<binary.length() && binary.charAt(j)!='1')
                {
                    j++;
                }
                if(j==binary.length()) j=0;
                max=Math.max(j-i,max);
            }
        }
        return max;
    }
}