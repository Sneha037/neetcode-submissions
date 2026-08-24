class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n-2; i++)
        {
            int a = (-1)*nums[i];
            if(i>0 && nums[i] == nums[i-1])
               continue;

            int l = i+1;
            int r = n-1;

            while(l<r)
            {
                int x = nums[l];
                int y = nums[r];

                int z = x+y;

                if(z == a)
                {
                    ArrayList<Integer> res = new ArrayList<>();

                    res.add(nums[i]);
                    res.add(x);
                    res.add(y);

                    ans.add(res);
                    l++;
                    r--;

                    while(l<r && (nums[l] == nums[l-1]))
                    {
                        l++;
                    }
                
                    while(l<r && (nums[r] == nums[r+1]))
                    {
                        r--;
                    }
                }
                else if(z > a)
                {
                    r--;
                }
                else
                {
                    l++;
                }
            }
        } 

        return ans;  
    }
}
