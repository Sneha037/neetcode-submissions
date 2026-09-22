class Solution {
    public int search(int[] nums, int target) 
    {
        int n = nums.length;
        
        int pivot = pivot(nums);

        //int a = nums[pivot];

        System.out.println(pivot);

        int l = 0;
        int r = pivot - 1;

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

        l = pivot;
        r = n-1;

        while(l<=r)
        {
            int mid = l + (r-l)/2;

            int a = nums[mid];

            if(a == target)
            {
                return mid;
            }
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
            else  if(mid == 0)
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
