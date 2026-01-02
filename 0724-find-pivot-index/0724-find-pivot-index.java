class Solution {
    public int pivotIndex(int[] arr) {
        int totalSum=0;
        int  n = arr.length;
        for(int a: arr)
        {
            totalSum+=a;
        } 

        int left=0;
        for(int i=0; i<n; i++)
        {
            int right=totalSum-arr[i]-left;
            if(left==right)
            {
                return i;
            }
            left=left+arr[i];
        }
        return -1;
    }
}