class Solution {
    public int subarraySum(int[] arr, int k) {

        int prefix[]=new int[arr.length];
        prefix[0]=arr[0];
        for(int i=1; i<arr.length; i++)
        {
            prefix[i]=arr[i] + prefix[i-1];
        }

        Map<Integer,Integer> map = new HashMap<>();
        
        int count=0;
        for(int j=0; j<prefix.length; j++)
        {
            if(prefix[j]==k)
            {
                count++;
            }
            if(map.containsKey(prefix[j]-k))
            {
                count=count+map.get(prefix[j]-k);
            }
            if(!map.containsKey(prefix[j]))
            {
                map.put(prefix[j],1);
            }
            else
            {
                map.put(prefix[j],map.get(prefix[j])+1);
            }

        }
        return count;
        
    }
}