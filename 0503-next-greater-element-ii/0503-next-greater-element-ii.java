class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int n=arr.length;
        int ans[]=new int[n];
        for(int i=n*2-1; i>=0; i--)
        {
            while(!st.isEmpty() && arr[i%n]>=arr[st.peek()%n])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                ans[i%n]=-1;
            }
            else
            {
                ans[i%n]=arr[st.peek()%n];
            }
            st.push(i);
        }
        return ans;
    }
}