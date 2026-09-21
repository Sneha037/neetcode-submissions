class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        /*

        The code here works but the instructions of the question is clear that we need to solve the question in O(1) auxillary space complexity and for that we can make use of the sorted property of the input integer array.

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
        */

        int n = numbers.length;

        int p1 = 0;
        int p2 = n - 1;

        int[] res = new int[2];

        while(p1<p2)
        {
            int a = numbers[p1];
            int b = numbers[p2];

            int sum = a+b;

            if(sum == target)
            {
                res[0] = p1+1;
                res[1] = p2+1;

                return res;
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

        return res;
    }
}
