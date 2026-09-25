class Solution {
    public int[] findRedundantConnection(int[][] edges) 
    {
        int m = edges.length;

        DSU dsu = new DSU(m);

        for(int[] edge : edges)
        {
            int a = edge[0]-1;
            int b = edge[1]-1;

            if(!dsu.union(a, b))
            {
                return edge;
            }
        }

        return new int[]{};
    }
}

public class DSU
{
    int[] parent;
    int[] rank;

    DSU(int n)
    {
        parent = new int[n];
        rank = new int[n];

        for(int i=0; i<n; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int n)
    {
        if(parent[n] != n)
        {
            parent[n] = find(parent[n]);
        }

        return parent[n];
    }

    public boolean union(int a, int b)
    {
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB)
        {
            return false;
        }

        if(rank[rootA] > rank[rootB])
        {
            parent[rootB] = rootA;
        }
        else if(rank[rootA] < rank[rootB])
        {
            parent[rootA] = rootB;
        }
        else
        {
            parent[rootA] = rootB;
            rank[rootB]++;
        }
        
        return true;
    }
}
