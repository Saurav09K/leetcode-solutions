class Solution {
    public int minElement(int[] arr) {
        int k=0;
        for(int a: arr)
        {
            String str = String.valueOf(a);
            int sum=0;
            for(int i=0; i<str.length(); i++)
            {
                sum=sum+(str.charAt(i)-'0');
            }
            arr[k++] = sum;
        }
        int min=arr[0];
        for(int a: arr)
        {
            min=Math.min(a,min);
        }
        return min;

    }
}