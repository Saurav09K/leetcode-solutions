class Solution {
    public int longestBalanced(int[] arr) {
        int max=0;
        for(int i=0; i<arr.length; i++)
        {
            Set<Integer> even = new HashSet<>();
            Set<Integer> odd = new HashSet<>();
            for(int j=i; j<arr.length; j++)
            {
                if(arr[j]%2==0)
                {
                    even.add(arr[j]);
                }
                else
                {
                    odd.add(arr[j]);
                }

                if(even.size()==odd.size())
                {
                    max=Math.max(j-i+1,max);
                }
            }
        }
        return max;
    }
}