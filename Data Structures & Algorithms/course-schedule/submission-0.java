class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        int[] courses = new int[numCourses];
        Arrays.fill(courses, 0);
        
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<numCourses; i++)
        {
            List<Integer> a = new ArrayList<>();
            graph.add(a);
        }

        int n = prerequisites.length;

        for(int i=0; i<n; i++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            graph.get(b).add(a);
            courses[a] = courses[a]+1;
        }
        
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++)
        {
            if(courses[i] == 0)
            {
                q.offer(i);
            }
        }

        while(!q.isEmpty())
        {
            int a = q.poll();

            for(int i=0; i<graph.get(a).size(); i++)
            {
                int p = graph.get(a).get(i);
                courses[p] = courses[p]-1;

                if(courses[p] == 0)
                {
                    q.offer(p);
                }
            }
        }

        for(int i=0; i<numCourses; i++)
        {
            if(courses[i] > 0)
            {
                return false;
            }
        }

        return true;
    }
}
