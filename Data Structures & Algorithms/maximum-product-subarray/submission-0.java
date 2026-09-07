class Solution {
    public int maxProduct(int[] nums) 
    {
        int n = nums.length;

        int min = nums[0];
        int max = nums[0];
        
        int ans = nums[0];

        int min_p = 1;
        int max_p = 1;

        for(int i=1; i<n; i++)
        {
            int a = nums[i];

            if(a < 0)
            {
                int temp = min;
                min = max;
                max = temp; 
            }
            
            min = Math.min(a, min*a);
            max = Math.max(a, max*a);
            
            ans = Math.max(ans, max);
        }

        return ans;
    }
}
