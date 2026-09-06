class Solution {
    public int climbStairs(int n) 
    {
        if(n<=1)
          return n;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;

        dp[2] = 2;

        return solve(n, dp);
    }

    public int solve(int n, int[] dp)
    {
        if(dp[n] != -1)
           return dp[n];

        dp[n] = solve(n-1, dp) + solve(n-2, dp);

        return dp[n];
    }
}
