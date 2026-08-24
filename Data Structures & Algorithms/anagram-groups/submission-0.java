class Solution {
    public List<List<String>> groupAnagrams(String[] strs) 
    {
        int n = strs.length;
        
        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> hm = new HashMap<>();

        for(int i=0; i<n; i++)
        {
            String a = strs[i];

            char[] carr = a.toCharArray();

            Arrays.sort(carr);

            String p = new String(carr);

           // hm.computeIfAbsent(carr, k->new ArrayList<String>()).add(a);

           if(!hm.containsKey(p))
           {
               hm.put(p, new ArrayList<String>());
           }
           
           hm.get(p).add(a);
        }

        for(List<String> string : hm.values())
        {
            res.add(string);
        }

        return res;
    }
}
