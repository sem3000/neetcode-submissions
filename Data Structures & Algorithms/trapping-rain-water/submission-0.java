class Solution {
    public int trap(int[] height) {
        int len = height.length;
        
        int[] leftMax = new int[len];
        leftMax[0] = height[0];
        for(int i=1; i<len; i++)
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
    
        int[] rightMax = new int[len];
        rightMax[len-1] = height[len-1];
        for(int j=len-2; j>=0; j--)
            rightMax[j] = Math.max(rightMax[j+1],height[j]);

        int ans = 0;
        for(int k=0; k<len; k++)
        {
            ans += Math.min(leftMax[k], rightMax[k]) - height[k];
        }
        return ans;
    }
}
