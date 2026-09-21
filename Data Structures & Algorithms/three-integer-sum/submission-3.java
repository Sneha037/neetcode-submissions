class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for(int i=0; i<n; i++)
        {
            int a = nums[i];

            if(i > 0 && a == nums[i-1])
               continue;

            int p1 = i+1;
            int p2 = n-1;

            while(p1<p2)
            {
                int b = nums[p1];
                int c = nums[p2];

                int sum = b+c;

                int target = -1*a;

                if(sum == ((-1)*a))
                {
                    List<Integer> ans = new ArrayList<>();

                    ans.add(a);
                    ans.add(b);
                    ans.add(c);

                    res.add(ans);

                    p1++;
                    p2--;

                    while(p1<n && nums[p1] == nums[p1-1])
                    {
                        p1++;
                    }

                    while(p2>p1 && nums[p2] == nums[p2+1])
                    {
                        p2--;
                    }
                }
                else if(sum < target)
                {
                    p1++;
                }
                else
                {
                    p2--;
                }
            }
        }

        return res;
    }
}
