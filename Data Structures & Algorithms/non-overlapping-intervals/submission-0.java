class Solution {
    public int eraseOverlapIntervals(int[][] intervals) 
    {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int min = 0;

        int prevEnd = intervals[0][1];

        for(int i=1; i<intervals.length; i++)
        {
            int[] p = intervals[i];

            if(p[0] < prevEnd)
            {
                min++;
            }
            else
            {
                prevEnd = p[1];
            }
        }

        return min;
    }
}
