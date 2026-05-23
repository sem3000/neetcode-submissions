class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] prefix = new int[length];
        prefix[0] = nums[0];

        int[] suffix = new int[length];
        suffix[length-1] = nums[length-1];

        for(int i=1; i<length; i++)
            prefix[i] = prefix[i-1] * nums[i];

        for(int j=length-2; j>=0; j--)
            suffix[j] = suffix[j+1] * nums[j];

        int[] res = new int[length];
        for(int i=0; i<length; i++)
        {
            if(i==0)
                res[i] = suffix[i+1];
            else if(i==length-1)
                res[i] = prefix[i-1];
            else
                res[i] = prefix[i-1] * suffix[i+1];
        }
        return res;
    }
}  
