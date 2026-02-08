class Solution {
    public int findMaxLength(int[] arr) {
        int prefixSum=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int maxLength=0;
        for(int j=0; j<arr.length; j++)
        {
            if(arr[j]==0) {
                sum=sum-1;
            }
             else{
                sum=sum+1;
            }

            if(map.containsKey(sum))
            {
                maxLength=Math.max(j-map.get(sum),maxLength);
            }
            else
            {
                map.put(sum,j);
            }
        }
        return maxLength;
    }
}