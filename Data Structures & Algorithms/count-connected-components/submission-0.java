class Solution {
    public int countComponents(int n, int[][] edges) 
    {
        int m = edges.length;
        
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            ArrayList<Integer> a = new ArrayList<>();
            graph.add(a);
        }

        for(int i=0; i<m; i++)
        {
            int a = edges[i][0];
            int b = edges[i][1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        int count = 0;

        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i, graph, visited);
            }
        }

        return count;
    }

    public void dfs(int node, List<List<Integer>> graph, boolean[] visited)
    {
        visited[node] = true;

        for(int i=0; i<graph.get(node).size(); i++)
        {
            int a = graph.get(node).get(i);

            if(!visited[a])
            {
                dfs(a, graph, visited);
            }
        }
    }
}
