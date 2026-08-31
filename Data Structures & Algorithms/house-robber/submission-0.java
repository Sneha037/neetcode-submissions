class Solution {
    public int rob(int[] nums) 
    {
        int n = nums.length;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        dp[0] = 0; 
        dp[1] = nums[0];  

        return solve(nums, n, dp);
    }

    public int solve(int[] nums, int i, int[] dp)
    {
        if(dp[i] != -1)
        {
            return dp[i];
        }

        int a = 0;

        a = Math.max(solve(nums, i-1, dp), solve(nums, i-2, dp) + nums[i-1]);

        dp[i] = a;

        return dp[i];
    }
}
