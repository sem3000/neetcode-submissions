class Solution {
    public int removeElement(int[] nums, int val) {
        
        int lastIndex = nums.length - 1;

        int count = 0;
        for(int n : nums)
            if(n==val)
                count++;

        for(int i=0; i<lastIndex; i++)
        {
            while(nums[lastIndex] == val && lastIndex>0)
                    lastIndex--;

            if(nums[i] == val)
            {
                int temp = nums[lastIndex];
                nums[lastIndex] = nums[i];
                nums[i] = temp;
            }
        }

        return nums.length - count;
    }
}