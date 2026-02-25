class Solution {
    public int[] sortByBits(int[] arr) {
        int binary[] = new int[arr.length];

        for(int i=0; i<arr.length; i++)
        {
            binary[i]=Integer.bitCount(arr[i]);
        }

        for(int i=0; i<binary.length-1; i++)
        {
            for(int j=0; j<binary.length-i-1; j++)
            {
                if(binary[j]>binary[j+1])
                {
                    int temp=binary[j];
                    binary[j]=binary[j+1];
                    binary[j+1]=temp;

                    int temp2=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp2;
                }
                else if(binary[j]==binary[j+1])
                {
                    if(arr[j]>arr[j+1])
                    {
                        int temp3=arr[j];
                        arr[j]=arr[j+1];
                        arr[j+1]=temp3;
                    }
                }
            }
        }
        return arr;
    }
}