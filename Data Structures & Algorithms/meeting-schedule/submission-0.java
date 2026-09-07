/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) 
    {
        int n = intervals.size();

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return Integer.compare(a.end, b.end);
            }
        });

        boolean ans = true;

        for(int i=1; i<n; i++)
        {
            int s = intervals.get(i).start;
            int e = intervals.get(i).end;

            if(s < intervals.get(i-1).end)
            {
                ans = false; break;
            }
        }

        return ans;
    }
}
