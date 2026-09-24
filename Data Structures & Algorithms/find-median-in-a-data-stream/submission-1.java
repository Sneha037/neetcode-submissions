class MedianFinder {

    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() 
    {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) 
    {
        maxHeap.add(num);

        if(maxHeap.size() - minHeap.size() > 1)
        {
            minHeap.offer(maxHeap.poll());
        }
        
        
        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())
        {
            int temp = minHeap.poll();
            minHeap.offer(maxHeap.poll());
            maxHeap.offer(temp);
        }

        if(minHeap.size() - maxHeap.size() > 1)
        {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() 
    {
        if(maxHeap.size() == minHeap.size())
        {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        else
        {
            return (double)maxHeap.peek();
        }
        
        /*
        else if(maxHeap.size() > minHeap.size())
        {
            return (double)maxHeap.peek();
        }  
        else
        {
            return (double)minHeap.size();
        } 
        */     
    }
}
