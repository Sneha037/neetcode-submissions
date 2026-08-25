class Solution {
    public int findMin(int[] nums) 
    {
        int n = nums.length;
        
        if(n == 1)
           return nums[0];

        if(nums[0] < nums[n-1])
           return nums[0];

        int a = nums[pivot(nums)];

       // System.out.println(a);

        return a;
    }

    public int pivot(int[] nums)
    {
        int l = 0;
        int r = nums.length-1;

        int n = nums.length;

        while(l<r)
        {
            int mid = l + (r-l)/2;

            if(mid == 0 && nums[mid] < nums[n-1])
               return mid;
            else if(mid == 0)
               return mid+1;
            
            if(mid == n-1 && nums[mid] > nums[0])
               return 0;
            else if(mid == n-1)
               return n-1;

            if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1])
            {
                return mid;
            }
            else if(nums[mid] > nums[0])
            {
                l = mid+1;
            }
            else
            {
                r = mid;
            }
        }

        return l;
    }
}
