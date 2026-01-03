class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int i=0,j=n-1;
        int maxleft=height[0];
        int maxright=height[n-1];
        int water=0;
        while(i<j)
        {
            int minHeight=Math.min(maxleft,maxright);
            if(height[i]<height[j])
            {
                water=water+Math.abs(height[i]-minHeight);
                i++;
                maxleft=Math.max(maxleft,height[i]);
            }
            else
            {
                water=water+Math.abs(height[j]-minHeight);
                j--;
                maxright=Math.max(maxright,height[j]);
            }
        }
        return water;
    }
}