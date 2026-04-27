class Solution {
    Map<String,Character> map;
    Map<String,Integer> dp;
    public int f(String s, int index,int n)
    {   
        int count=0;
        if(index==n)
        {
            return 1;
        } 

        if(dp.containsKey(s.substring(index)))
        {
            return dp.get(s.substring(index));
        }

        for(int i=index; i<n; i++)
        {
            String str = s.substring(index,i+1);
            if(map.containsKey(str))
            {
                count = count + f(s,i+1,n);
            }
            else
            {
                break;
            }
        }
        dp.put(s.substring(index), count);
        return count;
    }
    public int numDecodings(String s) {
        map = new HashMap<>();
        dp = new HashMap<>();

       
        for(int i=1; i<=26; i++)
        {
            char ch = (char) ('A'+i-1);
            map.put(String.valueOf(i),ch);
        }

        return f(s,0,s.length());
    }
}