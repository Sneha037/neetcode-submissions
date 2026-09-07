class Solution {
    public int reverseBits(int n) 
    {
        int a = 31;
        
        int p = n;

        int ans = 0;

        while(p!=0)
        {
            int d = p&1;

            ans = ans | (d<<a);
            a--;
            p>>>=1;
        }

        return ans;
    }
}
