class Solution {
    public boolean validTree(int n, int[][] edges) 
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

        int[] visited = new int[n];

        if(!check(0, -1, graph, visited))
           return false;

        for(int i=0; i<n; i++)
        {
            if(visited[i] == 0)
               return false;
        }

        return true;
    }

    public boolean check(int node, int parent, List<List<Integer>> graph, int[] visited)
    {
        visited[node] = 1;

        for(int i=0; i<graph.get(node).size(); i++)
        {
            int a = graph.get(node).get(i);

            if(a != parent)
            {
                if(visited[a] != 0)
                  return false;

                if(!check(a, node, graph, visited))
                   return false;
            }
        }

        return true;
    }
}
