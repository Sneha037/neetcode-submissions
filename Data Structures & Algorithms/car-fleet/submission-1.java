class Solution 
{
    public int carFleet(int target, int[] position, int[] speed) 
    {
        /*
        HashSet<Double> hs = new HashSet<>();

        for(int i=0; i<position.length; i++)
        {
            int p = position[i];
            int s = speed[i];

            double d = (target-p)/(double)s;

            hs.add(d);
        }   

        return hs.size();
        */

        int n = position.length;

        int[][] cars = new int[n][2];

        for(int i=0; i<n; i++)
        {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        Stack<Double> st = new Stack<>();

        for(int i=0; i<n; i++)
        {
            int p = cars[i][0];
            int s = cars[i][1];

            double time = (target-p)/(double)s;

            if(st.isEmpty() || time > st.peek())
            {
                st.push(time);
            }
        }

        return st.size();
    }
}
