class Solution {
    public int maxSum(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int currentSum=0;
        int maxSum=Integer.MIN_VALUE;

        for(int i=0; i<arr.length; i++)
        {
            if(!set.contains(arr[i]))
            {
                currentSum=Math.max(currentSum+arr[i],arr[i]);
                maxSum=Math.max(maxSum,currentSum);
                set.add(arr[i]);
                currentSum=maxSum;
            }
        }
        return maxSum;
    }
}