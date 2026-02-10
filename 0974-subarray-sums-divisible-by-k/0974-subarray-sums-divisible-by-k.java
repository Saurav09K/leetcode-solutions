class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        int prefix=0;
        for(int i=0; i<arr.length; i++)
        {
            prefix=prefix+arr[i];

            int rem = prefix % k;

            if(rem < 0) rem += k;

            if(rem == 0) count++;

            if(map.containsKey(rem))
            {
                count = count + map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}