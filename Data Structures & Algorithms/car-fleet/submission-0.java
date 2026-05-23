class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target];
        for(int i=0; i<position.length; i++)
        {
            time[position[i]] = (double)(target - position[i]) / speed[i];
        }

        double maxTime = 0.0;
        int fleet = 0;
        for(int i=target-1; i>=0; i--)
        {   
            double t = time[i];
            if(t > maxTime)
            {
                maxTime = t;
                fleet++;
            }
        }
        return fleet;
    }
}
