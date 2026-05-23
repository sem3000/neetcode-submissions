class KthLargest {
    PriorityQueue<Integer> pq;
    int topK;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        topK = k;

        for(int i=0; i<nums.length && i<k; i++)
        {
            pq.offer(nums[i]);
        }
        for(int i=k ; i<nums.length; i++)
        {
            if(nums[i] >= pq.peek())
            {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < topK)
        {
            pq.offer(val);
        }
        else
        {
            if(val > pq.peek())
            {
                pq.poll();
                pq.offer(val);
            }
        }
        
        return pq.peek();
    }
}
