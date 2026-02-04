class Solution {
    int countPrimes(int n){
        if(n==0||n==1)
        {
            return 0;
        }
        boolean prime[]=new boolean[n];
        Arrays.fill(prime,true);

        prime[0]=false;
        prime[1]=false;

        for(int i=2; i<=Math.sqrt(n); i++)
        {
            if(prime[i]==true)
            {
                for(int j=2; i*j<n; j++)
                {
                    prime[i*j]=false;
                }
            }
        }

        int count=0;
        for(int i=2; i<prime.length; i++)
        {
            if(prime[i]==true) count++;
        }
        return count;
        
    }
}