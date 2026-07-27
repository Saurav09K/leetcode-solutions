class Solution {
    public int countKDifference(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;

        for(int i=0; i<arr.length; i++)
        {
            int num1=arr[i]-k;
            int num2=arr[i]+k;

            if(map.containsKey(num1))
            {
                count=count+map.get(num1);
            }
            if(map.containsKey(num2))
            {
                count=count+map.get(num2);
            }
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        return count;
    }
}