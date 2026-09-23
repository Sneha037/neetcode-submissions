class Solution {
    public int maxProfit(int[] prices) 
    {
        int n = prices.length;

        int min = prices[0];

        int ans = 0;

        for(int i=1; i<n; i++)
        {
            min = Math.min(min, prices[i]);

            ans = Math.max(ans, prices[i] - min);
        }        

        return ans;
    }
}
