class TimeMap {
     
    HashMap<String, List<Pair>> hm;
    public TimeMap() {
        hm = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) 
    {
        hm.putIfAbsent(key, new ArrayList<>()); 

        hm.get(key).add(new Pair(timestamp, value));  
    }
    
    public String get(String key, int timestamp) 
    {
        if(!hm.containsKey(key))
        {
            return "";
        }  

        String result = "";

        List<Pair> list = hm.get(key);

        int left = 0;
        int right = list.size()-1;

        while(left<=right)
        {
            int mid = left + (right - left)/2;

            if(list.get(mid).timestamp <= timestamp)
            {
                result = list.get(mid).value;

                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }

        return result;
    }
}

class Pair
{
    int timestamp;
    String value;

    public Pair(int timestamp, String value)
    {
        this.timestamp = timestamp;
        this.value = value;
    }
}
