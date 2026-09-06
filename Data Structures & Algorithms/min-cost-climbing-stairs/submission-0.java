class Solution {
    public int minCostClimbingStairs(int[] cost) 
    {
        int n = cost.length;

        if(n<=1)
         return 0;

        if(n<=2)
          return Math.min(cost[0], cost[1]);

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 0;

        int a = solve(cost, 0, n, dp);

       /* Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = 0;
        //dp[2] = 0;

        int b = solve(cost, 1, n, dp);
        */

        return dp[n];
    }

    public int solve(int[] cost, int i, int n, int[] dp)
    {
        if(n==0 || n==1)
          return 0;

        if(dp[n] != -1)
        {
            return dp[n];
        }

        int a = Math.min(solve(cost, i, n-1, dp) + cost[n-1], solve(cost, i, n-2, dp) + cost[n-2]);

        dp[n] = a;

        return dp[n];
    }
}
