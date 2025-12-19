/* base case can be optimised like this also, for not going deep in recursion
    if(capacity==0)
        {
            return 0;
        }
        if(n==1)
        {
            return (capacity/wt[0]) * val[0];
        }
*/
class Solution {
    public int f(int val[],int wt[],int capacity,int n)
    {
        if(capacity==0 || n==0)    
        {
            return 0;
        }
        
        int take=Integer.MIN_VALUE;
        if(wt[n-1]<=capacity)
        {
            take=val[n-1]+f(val,wt,capacity-wt[n-1],n); // called at the same index
        }
        int notTake=f(val,wt,capacity,n-1);
        
        return Math.max(take,notTake);
    }
    public int knapSack(int val[], int wt[], int capacity) {
        int n=val.length;
        
        return f(val,wt,capacity,n);
        
    }
}
