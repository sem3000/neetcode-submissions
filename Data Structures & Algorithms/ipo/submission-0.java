class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[1] - a[1]);//profits
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0] - b[0]);//capital
        //[0]-capital; [1]-profits

        for(int i=0; i<capital.length; i++)
            minHeap.offer(new int[]{capital[i],profits[i]});

        for(int i=0; i<k; i++)
        {
            while(!minHeap.isEmpty() && minHeap.peek()[0] <= w)
            {
                maxHeap.offer(minHeap.poll());
            }

            if(maxHeap.isEmpty())
                break;
            
            w += maxHeap.poll()[1];
        }
        return w;
    }
}