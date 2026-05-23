class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target];
        for(int i=0; i<position.length; i++)
        {
            time[position[i]] = (target - position[i]) /(double)speed[i];
        }
        int fleet=0;
        double currentMaxTime = 0.0;
        for(int i=time.length-1; i>=0; i--)
        {
            if(time[i] > currentMaxTime)
            {
                fleet++;
                currentMaxTime = time[i];
            }
        }   
        return fleet;
    }
}
