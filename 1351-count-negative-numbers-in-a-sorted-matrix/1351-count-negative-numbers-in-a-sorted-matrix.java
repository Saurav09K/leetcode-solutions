class Solution {
    public int bs(int arr[])
    {
        int start=0,end=arr.length-1;
        int ans=-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(arr[mid]<0)
            {
                ans=mid;
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }
        }
        if(ans!=-1)
        {
            return arr.length-ans;
        }

        return -1;
    }
    public int countNegatives(int[][] arr) {
        int result=0;
        for(int i=0; i<arr.length; i++)
        {
            int x=bs(arr[i]);
            if(x!=-1)
            {
                result=result+x;
            }
        }
        return result;
    }
}