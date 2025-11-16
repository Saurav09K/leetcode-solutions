class Solution {
    public int maximizeExpressionOfThree(int[] arr) {
        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;
        int c=Integer.MAX_VALUE;

        for(int i=0; i<arr.length; i++)
        {
            if(arr[i]>a)  //if element greater than a
            {
                b=a;         //store a's value in b, because a higher value is found than previous higher
                a=arr[i]; // update that higher value to a
            }
            else if(arr[i]>b) // if its not greater than a, but i can be greater than b 
            {
                b=arr[i]; // update the value of b, if it is greater
            }

            if(arr[i]<=c) // while iterating also keep track of the smallest element in array
            {
                c=arr[i];
            }
        }
        return a+b-c; // return the maximum obtained expression
    }
}
//find maximum and 2nd maximum and smallest in array
