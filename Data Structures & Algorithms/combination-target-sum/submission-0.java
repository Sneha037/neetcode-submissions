class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) 
    {
        int n = nums.length;

        List<List<Integer>> res = new ArrayList<>();
        
        backtrack(nums, res, 0, target, target, new ArrayList<>());

        return res;
    }

    public void backtrack(int[] nums, List<List<Integer>> res, int index, int target, int sum, List<Integer> subList)
    {
        /*if(index > nums.length)
          return;
          */

        if(sum < 0)
          return;
        
        if(sum == 0)
        {
            res.add(new ArrayList<>(subList));
            return;
        }
       
       for(int i=index; i<nums.length; i++)
       {
            subList.add(nums[i]);
            backtrack(nums, res, i, target, sum-nums[i], subList);
            subList.remove(subList.size()-1);
       }
    }
}
