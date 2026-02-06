class Solution {
    public int minRemoval(int[] arr, int k) {
        Arrays.sort(arr);

        int i=0,j=0;
        int n=arr.length;
        int length=0;
        while(j<n)
        {
            while((long)arr[i]*k<arr[j])
            {
                i++;
            }
            if((long)arr[i]*k>=arr[j])
            {
                length=Math.max(j-i+1,length);
            }
            j++;
        }
        return arr.length-length;
    }
}
// 1 3 6 9
// 1 1 2 9