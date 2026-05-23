class MedianFinder {
    PriorityQueue<Double> maxHeap;
    PriorityQueue<Double> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer((double)num);

        if(!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() >= minHeap.peek())
        {
            minHeap.offer(maxHeap.poll());
        }

        if(maxHeap.size() > minHeap.size() + 1)
        {
            minHeap.offer(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size())
        {
            maxHeap.offer(minHeap.poll());
        }
        
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
        {
            return (minHeap.peek() + maxHeap.peek()) / 2;
        }
        else
        {
            return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }
    }
}
