class Solution {
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;

        //int max = -1;
        int min = Integer.MAX_VALUE;

        int ans = 0;

        for(int i=0; i<n; i++)
        {
            int a = prices[i];

            min = Math.min(min, a);

            if(min!= Integer.MAX_VALUE && (a-min)>ans)
            {
                ans = a - min;
            }
        }
        
        return ans;
    }
}
