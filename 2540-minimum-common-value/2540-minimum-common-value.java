class Solution {
    public int getCommon(int[] arr, int[] brr) {
        int i=0,j=0;
        int m=arr.length;
        int n=brr.length;
        while(i<m && j<n)
        {
            if(arr[i]==brr[j])
            {
                return arr[i];
            }
            else if(arr[i]<brr[j])
            {
                i++;
            }
            else
            {
                j++;
            }
        }
        return -1;
    }
}