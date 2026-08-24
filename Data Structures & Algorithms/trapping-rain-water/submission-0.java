class Solution {
    public int trap(int[] height) 
    {
        int n = height.length;

        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = 0;
        right[n-1] = 0;

        int maxLeft = 0;
        int maxRight = 0;

        for(int i=1; i<n; i++)
        {
            maxLeft = Math.max(maxLeft, height[i-1]);
            left[i] = maxLeft;
        }

        for(int i=n-2; i>=0; i--)
        {
            maxRight = Math.max(maxRight, height[i+1]);
            right[i] = maxRight;
        }

        int ans = 0;

        for(int i=0; i<n; i++)
        {
            if((Math.min(left[i], right[i]) - height[i]) > 0)
            {
                ans+= Math.min(left[i], right[i]) - height[i];
            }
        }

        return ans;
    }
}
