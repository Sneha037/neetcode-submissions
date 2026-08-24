class Solution {
    public int maxArea(int[] heights) 
    {
        int n = heights.length;

        int p1 = 0;
        int p2 = n-1;

        int max = 0;

        while(p1<p2)
        {
            int a = heights[p1];
            int b = heights[p2];

            int p = Math.min(a, b) * (p2-p1);

            max = Math.max(max, p);

            if(a>=b)
            {
                p2--;
            }
            else
            {
                p1++;
            }
        }  

        return max; 
    }
}
