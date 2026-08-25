class Solution {
    public int[] countBits(int n) 
    {
        int[] ans = new int[n+1];

        ans[0] = 0;
        
        for(int i=1; i<=n; i++)
        {
            int a = i;
            int count = 0;

            while(a!=0)
            {
                if((a&1)==1)
                  count++;
                
                a>>=1;
            }

            ans[i] = count;
        }

        return ans;
    }
}
