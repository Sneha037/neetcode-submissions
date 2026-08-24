class Solution {

    public String encode(List<String> strs) 
    {
       /* StringBuilder sb = new StringBuilder();

        int n = strs.size();

        for(int i=0; i<n; i++)
        {
            sb.append(strs.get(i));
            if(i!=n-1)
             sb.append(":");
        }
        
        return new String(sb);
        */

        int n = strs.size();

        StringBuilder sb = new StringBuilder();

        for(String str : strs)
        {
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) 
    {
        /*String[] ls = str.split(":");

        List<String> res = new ArrayList<>();
        for(int i=0; i<ls.length; i++)
        {
            res.add(ls[i]);
        }

        return res;
        */

        List<String> res = new ArrayList<>();

        int n = str.length();

        int i=0; 

        while(i<n)
        {
            int j = i;

            while(str.charAt(j) != '#')
            {
                j++;
            } 

            int len = Integer.parseInt(str.substring(i, j));

            res.add(str.substring(j+1, j+1+len));

            i = j+1+len;
        }

        return res;
    }
}
