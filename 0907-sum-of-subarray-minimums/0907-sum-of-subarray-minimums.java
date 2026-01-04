class Solution {
    public void leftSmaller(int arr[],int left[])
    {
        int n=arr.length;
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++)
        {
            while(!st.isEmpty() && arr[i]<arr[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            {
                left[i]=-1;
            }
            else
            {
                left[i]=st.peek();
            }
            st.push(i);
        }
    }
     public void rightSmaller(int arr[],int left[])
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
                left[i]=n;
            }
            else
            {
                left[i]=st.peek();
            }
            st.push(i);
        }
    }
    public int sumSubarrayMins(int[] arr) {
        int MOD=1_000_000_007;
        int n=arr.length;
        int left[]=new int[n];
        int right[]=new int[n];

        leftSmaller(arr,left);
        rightSmaller(arr,right);

        long sum=0;
        for(int i=0; i<n; i++)
        {
            long l = i - left[i];
            long r = right[i] - i;

            sum = (sum + ((l * r)%MOD * arr[i]) % MOD) % MOD; //overflow solved by MOD
        }
        return (int)sum;
    }
}