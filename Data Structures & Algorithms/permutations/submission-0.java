class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        int n = nums.length;
        
        List<List<Integer>> res = new ArrayList<>();

        boolean[] used = new boolean[n];

        backtrack(nums, res, used, new ArrayList<Integer>());

        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, boolean[] used, List<Integer> perm)
    {
        if(perm.size() == nums.length)
        {
            res.add(new ArrayList<>(perm));
            return;
        }

        for(int i=0; i<nums.length; i++)
        {
            if(used[i])
              continue;
            perm.add(nums[i]);
            used[i] = true;
            backtrack(nums, res, used, perm);
            used[i] = false;
            perm.remove(perm.size()-1);
        }
    }
}
