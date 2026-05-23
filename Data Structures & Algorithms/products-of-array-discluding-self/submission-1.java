class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] rPre = new int[nums.length];
        int[] lPre = new int[nums.length];

        rPre[0] = nums[0];
        lPre[nums.length-1] = nums[nums.length-1];

        for(int i=1; i<nums.length; i++)
            rPre[i] = rPre[i-1] * nums[i];

        for(int i=nums.length-2; i>=0; i--)
            lPre[i] = lPre[i+1] * nums[i];

        int[] product = new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {
            if(i==0)
            {
                product[i] = lPre[i+1];
            }
            else if(i==nums.length-1)
            {
                product[i] = rPre[i-1];
            }
            else
             product[i] = rPre[i-1] * lPre[i+1];

        }
        return product;
    }
}  
