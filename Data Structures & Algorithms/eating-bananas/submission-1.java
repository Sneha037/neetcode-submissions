class Solution {
    public int minEatingSpeed(int[] piles, int h) 
    {
        int n = piles.length;
        
        //int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<n; i++)
        {
           // min = Math.min(min, piles[i]);
            max = Math.max(max, piles[i]);
        }

        int left = 1;
        int right = max;

        int res = Integer.MAX_VALUE;

        while(left<=right)
        {
            int mid = left + (right-left)/2;

            int ans = 0; boolean flag = true;

            for(int i=0; i<n; i++)
            {
                int a = piles[i];

                ans+= a/mid;
                ans+= (a%mid == 0) ? 0 : 1;
                if(ans>h)
                {
                    flag = false;
                    break;
                }
            }

            if(flag)
            {
                res = Math.min(res, mid);
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }

        return res;
    }
}
