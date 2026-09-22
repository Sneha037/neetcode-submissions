class Solution {
    public int findMin(int[] nums) 
    {
        int n = nums.length;
        
        int l = 0;
        int h = n-1;

        int pivot = pivot(nums);

        return nums[pivot];
    }

    public int pivot(int[] nums)
    {
        int n = nums.length;

        if(n == 1)
           return 0;

        int l = 0;
        int r = n-1;

        while(l<=r)
        {
            int mid = l + (r-l)/2;

            if(mid == 0 && nums[mid] < nums[n-1])
               return mid;
            else if(mid == 0)
               return mid+1;

            if(mid == n-1 && nums[mid] > nums[0])
                return 0;
            else if(mid == n-1)
                return mid;

            if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1])
            {
                return mid;
            }
            else if(nums[mid] < nums[0])
            {
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }
        }
        
        //unreachable statement
        return -1;
    }
}
