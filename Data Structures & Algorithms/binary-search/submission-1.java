class Solution {
    public int search(int[] nums, int target) 
    {
        int n = nums.length;

        int l = 0;
        int r = n-1;

        while(l<=r)
        {
            int mid = l + (r-l)/2;

            int a = nums[mid];

            if(a == target)
                return mid;
            else if(a > target)
            {
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }  

        return -1; 
    }
}
