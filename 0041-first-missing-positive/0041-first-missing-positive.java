class Solution {
    public int firstMissingPositive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int a: arr)
        {
            if(a>0) set.add(a);
        }
        for(int i=1; i<=arr.length+1; i++)
        {
            if(!set.contains(i))
            {
                return i;
            }
        }
        return -1;
    }
}