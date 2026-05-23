class Solution {
    public int[] getConcatenation(int[] nums) {
        int resLength = nums.length * 2;
        int[] result = new int[resLength];
        for(int i=0; i<nums.length; i++)
        {
            result[i] = result[i + nums.length] = nums[i];
        }
        return result;
    }
}