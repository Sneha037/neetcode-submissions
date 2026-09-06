class Solution {
    public int rob(int[] nums) 
    {
        int n = nums.length;

        if(n==1)
          return nums[0];

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 0;
        dp[1] = nums[0];

        int a = solve(nums, dp, 1, n-1);

        
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = nums[1];

        int b = solve(nums, dp, 2, n);

        return Math.max(a, b);
    }

    public int solve(int[] nums, int[] dp, int i, int j)
    {
        if(i > j)
          return 0;

        if(dp[j] != -1)
           return dp[j];

        int a = Math.max(solve(nums, dp, i, j-1), solve(nums, dp, i, j-2) 
                                                  + nums[j-1]);
        
        dp[j] = a;

        return dp[j];
    }
}
