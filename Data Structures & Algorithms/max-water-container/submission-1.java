class Solution {
    public int maxArea(int[] heights) 
    {
        int n = heights.length;

        int p1 = 0;
        int p2 = n-1;

        int res = Integer.MIN_VALUE;

        while(p1<p2)
        {
            int a = heights[p1];
            int b = heights[p2];

            res = Math.max(res, Math.min(a, b) * Math.abs(p2-p1));

            if(a < b)
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
