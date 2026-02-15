class Solution {
    public int firstMissingPositive(int[] arr) {
        
        int i=0;
        while(i<arr.length)
        {
            if(arr[i]<=0 || arr[i]>arr.length)
            {
                i++;
                continue;
            } 
            int correctIndex = arr[i]-1;

            if(arr[correctIndex]!=arr[i])
            {
                int temp = arr[correctIndex];
                arr[correctIndex] = arr[i];
                arr[i] = temp;
            }
            else
            {
                i++;
            }
        }

        int k=0;
        for(k=0; k<arr.length; k++)
        {
            if(arr[k]!=k+1)
            {
                return k+1;
            }
        }
        return k+1;
    }
    
}