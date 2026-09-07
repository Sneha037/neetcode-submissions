class Solution {
    public int coinChange(int[] coins, int amount) 
    {
        int n = coins.length;
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        int val = solve(coins, amount, dp);

        return (val == Integer.MAX_VALUE) ? -1 : val;
    }

    public int solve(int[] coins, int amount, int[] dp)
    {
        if(dp[amount] != -1)
        {
            return dp[amount];
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<coins.length; i++)
        {
            int a = coins[i];

            if(a <= amount)
            {
                int b = solve(coins, amount-a, dp);
                if(b != Integer.MAX_VALUE)
                   min = Math.min(min, b+1);
            }
        }

        dp[amount] = min;

        return dp[amount];
    }
}
