class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++)
        {
            for(int j=i+1; j<nums.length; j++)
            {
                for(int k=j+1; k<nums.length; k++)
                {
                    int a=nums[i];
                    int b=nums[j];
                    int c=nums[k];

                    int result=0;
                    if(a<=b && a<=c)
                    {
                        result=b+c-a;
                    }
                    else if(b<=a && b<=c)
                    {
                         result=a+c-b;
                    }
                    else
                    {
                        result=a+b-c;
                    }

                    
                    max=Math.max(result,max);
                }
            }
        }
        return max;
    }
}