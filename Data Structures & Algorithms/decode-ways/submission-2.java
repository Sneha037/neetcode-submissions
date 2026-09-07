class Solution {
    public int numDecodings(String s) 
    {
        int n = s.length();

        if(s.charAt(0) == '0')
           return 0;

        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;

        return solve(s, n, dp);
    }

    public int solve(String s, int i, int[] dp)
    {
        if(dp[i] != -1)
          return dp[i];

        char a = s.charAt(i-1);
        char b = s.charAt(i-2);

        int count = 0;

        if(a >= '1' && a<= '9')
        {
            count+= solve(s, i-1, dp);
        }
        
        if(b == '1' || (b == '2' && (a >= '0' && a<= '6')))
        {
            count+= solve(s, i-2, dp);
        }

        dp[i] = count;
        
        return dp[i];
    }
}
