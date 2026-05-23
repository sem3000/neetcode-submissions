class Cod
{
    int[] set;
    int distance;

    Cod(int[] set, int d)
    {
        this.set = set;
        this.distance = d;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Cod> pq = new PriorityQueue<>((a,b)->a.distance - b.distance);

        for(int i=0; i<points.length; i++)
        {
            int distance = (points[i][0] * points[i][0]) +
                            (points[i][1] * points[i][1]);
            pq.offer(new Cod(points[i],distance)); 
        }
        int[][] res = new int[k][2];
        for(int i=0; i<k; i++)
        {
            res[i] = pq.poll().set;
        }
        return res;
    }
}
