class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) 
    {
        int[] courses = new int[numCourses];
        Arrays.fill(courses, 0);

        List<List<Integer>> graph = new ArrayList<>();

        int n = prerequisites.length;

        for(int i=0; i<numCourses; i++)
        {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++)
        {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];

            graph.get(b).add(a);

            courses[a] = courses[a] + 1;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++)
        {
            if(courses[i] == 0)
              q.offer(i);
        }

        System.out.println(q.size());

        List<Integer> ans = new ArrayList<>();

        while(!q.isEmpty())
        {
            int a = q.poll();
            ans.add(a);

            for(int i=0; i<graph.get(a).size(); i++)
            {
                int p = graph.get(a).get(i);
                courses[p] = courses[p] - 1;

                if(courses[p] == 0)
                {
                    q.offer(p);
                }
            }
        }

        if(ans.size() < numCourses)
        {
            return new int[]{};
        }

        int[] res = new int[ans.size()];

        for(int i=0; i<ans.size(); i++)
        {
            res[i] = ans.get(i);
        }

        return res;
    }
}
