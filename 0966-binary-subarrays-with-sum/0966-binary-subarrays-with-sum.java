class Solution {
    public int numSubarraysWithSum(int[] arr, int goal) {
        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1; i<arr.length; i++)
        {
            prefix[i]=arr[i]+prefix[i-1];
        }
        Map<Integer,Integer> map=new HashMap<>();
        
        int sum=0;
        int temp=0;
        for(int i=0; i<prefix.length; i++)
        {
            if(prefix[i]==goal)
            {
                sum++;
            }

            int ith_value=prefix[i]-goal;
            
            if(map.containsKey(ith_value))
            {
                sum=sum+map.get(ith_value);
            }
             if(!map.containsKey(prefix[i]))
            {
                map.put(prefix[i],1);
            }
            else
            {
                map.put(prefix[i],map.get(prefix[i])+1);
            }
            
        }
        return sum;

    }
}