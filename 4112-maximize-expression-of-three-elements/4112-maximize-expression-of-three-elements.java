class Solution {
    public int maximizeExpressionOfThree(int[] arr) {
        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        int c=Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>a)
            {
                b=a;
                a=arr[i];
            }
            else if(arr[i]>b)
            {
                b=arr[i];
            }

            if(arr[i]<=c)
            {
                c=arr[i];
            }
        }
        return a+b-c;
    }
}
//find maximum and 2nd maximum and smallest in array