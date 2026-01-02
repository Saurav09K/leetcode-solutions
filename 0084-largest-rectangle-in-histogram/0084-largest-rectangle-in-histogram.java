class Solution {
    public void leftNearestSmaller(int arr[],int ans[])
    {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans[i]=-1;
            }
            else
            {
                ans[i]=st.peek();
            }
            st.push(i);
        }
    }
    public void rightNearestSmaller(int arr[],int ans[])
    {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=n-1; i>=0; i--)
        {
            while(!st.isEmpty() && arr[i]<=arr[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans[i]=n;
            }
            else
            {
                ans[i]=st.peek();
            }
             st.push(i);
        }
    }
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;

        int left[]=new int[n];
        int right[]=new int[n];

        leftNearestSmaller(heights,left);
        rightNearestSmaller(heights,right);

        int ans=Integer.MIN_VALUE;

        for(int i=0; i<n; i++)
        {
            int length=heights[i];
            int width=right[i]-left[i]-1;
            int area=length*width;

            ans=Math.max(area,ans);
        }
        return ans;
    }
}