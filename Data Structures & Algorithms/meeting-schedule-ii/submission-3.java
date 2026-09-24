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
    public int minMeetingRooms(List<Interval> intervals) 
    {
        int n = intervals.size();

        if(n==0)
           return 0;

        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int min = 0;

        int prevEnd = intervals.get(0).end;

        for(int i=0; i<n; i++)
        {
            if(!pq.isEmpty())
            {
                if(intervals.get(i).start >= pq.peek())
                {
                    pq.poll();
                }
            }

            pq.offer(intervals.get(i).end);

            min = Math.max(min, pq.size());
        }

        return min;
    }
}
