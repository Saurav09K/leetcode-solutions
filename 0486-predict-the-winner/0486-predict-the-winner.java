class Solution {
    public int f(int arr[], int i, int j)
    {
        if(i>j) return 0;

        int pickLeft = arr[i] - f(arr,i+1,j);
        int pickRight = arr[j] - f(arr,i,j-1);

        return Math.max(pickLeft,pickRight);
    }
    public boolean predictTheWinner(int[] arr) {
        if(arr.length==1) return true;
        int scoreDiff =  f(arr,0,arr.length-1);
        return (scoreDiff>=0)? true: false;
    }
}