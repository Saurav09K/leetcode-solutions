class Solution {
    public int trap(int[] height) {
        int maxleftHeight[]=new int[height.length];
        int maxrightHeight[]=new int[height.length];

        maxleftHeight[0]=height[0];
        maxrightHeight[height.length-1]=height[height.length-1];

        for(int i=1; i<height.length; i++)
        {
            maxleftHeight[i]=Math.max(maxleftHeight[i-1],height[i]);
        }
        for(int i=height.length-2; i>=0; i--)
        {
            maxrightHeight[i]=Math.max(maxrightHeight[i+1],height[i]);
        }

        int water=0;
        for(int i=0; i<height.length; i++)
        {
            int minHeight=Math.min(maxleftHeight[i],maxrightHeight[i]);

            water=water+Math.abs(height[i]-minHeight);
        }
        return water;
    }
}
