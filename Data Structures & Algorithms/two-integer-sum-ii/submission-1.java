class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        int n = numbers.length;

        HashMap<Integer, Integer> hm = new HashMap<>();

        int[] res = new int[2];

        for(int i=0; i<n; i++)
        {
            int a = numbers[i];

            if(hm.containsKey(target - a))
            {
                res[0] = hm.get(target - a)+1;
                res[1] = i+1;

                return res;
            }

            hm.put(a, i);
        }

        return res;
    }
}
