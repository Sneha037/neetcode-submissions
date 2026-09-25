/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) 
    {
        if(node == null)
            return null;

        Map<Node, Node> hm = new HashMap<>();

        return solve(node, hm);
    }

    public Node solve(Node node, Map<Node, Node> map)
    {
        if(node == null)
           return null;

        if(map.containsKey(node))
        {
            return map.get(node);
        }
        
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        ArrayList<Node> cloneNeighbors = new ArrayList<Node>();
        for(int i=0; i<node.neighbors.size(); i++)
        {
            Node a = solve(node.neighbors.get(i), map);
            cloneNeighbors.add(a);
            map.put(node.neighbors.get(i), a);
        }
        clone.neighbors = cloneNeighbors;
        

        return clone;
    }
}