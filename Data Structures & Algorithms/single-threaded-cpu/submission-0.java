class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] tasksArr = new int[n][3];

        for(int i=0; i<n; i++)
        {
            tasksArr[i][0] = tasks[i][0]; //enqueue time
            tasksArr[i][1] = tasks[i][1]; //processing time
            tasksArr[i][2] = i; //index
        }
        Arrays.sort(tasksArr,(a,b)-> a[0]-b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[2]-b[2] : a[1]-b[1]);

        int resIdx = 0;
        int taskIdx = 0;
        int time =0;
        int[] result = new int[n];

        while(resIdx < n)
        {
            while(taskIdx < n && tasksArr[taskIdx][0] <= time )
            {
                pq.offer(tasksArr[taskIdx]);
                taskIdx++;
            }
            if(pq.isEmpty())
            {
                time = tasksArr[taskIdx][0];
            }
            else
            {
                int[] p = pq.poll();
                time += p[1];
                result[resIdx++] = p[2];
            }
        }
        return result;
    }
}