class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, (a,b) -> a[1] - b[1]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        //[0]-destination and [1]-passengers
        int currCap = 0;
        for(int i=0; i<trips.length; i++)
        {
            int pass = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];
            currCap += pass;

            pq.offer(new int[]{to, pass});

            while(!pq.isEmpty() && pq.peek()[0] <= from)
            {
                currCap -= pq.poll()[1];
            }

            if(currCap > capacity)
                return false;
        }
        return true;
    }
}