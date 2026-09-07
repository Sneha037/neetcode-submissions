class Solution {
    public int singleNumber(int[] nums) 
    {
        int n = nums.length;
        
        int a = 0;

        for(int i=0; i<n; i++)
        {
            a^= nums[i];
        }

        return a;
    }
}
