class Solution {
    public List<String> letterCombinations(String digits) 
    {
        int n = digits.length();
        //System.out.println(n);
        
        List<String> res = new ArrayList<>();
        
        if(n == 0)
          return res;
        
        HashMap<Integer, char[]> hm = new HashMap<Integer, char[]>();

        hm.put(0, new char[]{});
        hm.put(1, new char[]{});
        hm.put(2, new char[]{'a', 'b', 'c'});
        hm.put(3, new char[]{'d', 'e', 'f'});
        hm.put(4, new char[]{'g', 'h', 'i'});
        hm.put(5, new char[]{'j', 'k', 'l'});
        hm.put(6, new char[]{'m', 'n', 'o'});
        hm.put(7, new char[]{'p', 'q', 'r', 's'});
        hm.put(8, new char[]{'t', 'u', 'v'});
        hm.put(9, new char[]{'w', 'x', 'y', 'z'});

        backtrack(digits, hm, 0, res, new StringBuilder());

        return res;
    }

    public void backtrack(String s, HashMap<Integer, char[]> hm, int index, List<String> res, StringBuilder current)
    {
        if(index == s.length())
        {
            res.add(current.toString());
            return;
        }

        char[] arr = hm.get(s.charAt(index) - '0');

        for(int i=0; i<arr.length; i++)
        {
            char ch = arr[i];

            current.append(ch);

            backtrack(s, hm, index+1, res, current);

            current.deleteCharAt(current.length() - 1);
        }
    }
}
