class Solution {
    public int[] twoSum(int[] numbers, int target) 
    {
        int n = numbers.length;

        int p1 = 0; int p2 = n-1;

        int res[] = new int[2];

        while(p1<p2)
        {
            int a = numbers[p1];
            int b = numbers[p2];

            if((a+b) == target)
            {
                res[0] = p1+1;
                res[1] = p2+1;
                return res;
            }
            else if((a+b) > target)
            {
                p2--;
            }
            else
            {
                p1++;
            }
        }
        
        return res;
    }
}
