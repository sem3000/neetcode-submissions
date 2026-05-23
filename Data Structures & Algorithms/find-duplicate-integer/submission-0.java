class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do
        {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);

        int pt1 = nums[0];
        int pt2 = slow;

        while(pt1 != pt2)
        {
            pt1 = nums[pt1];
            pt2 = nums[pt2];
        }

        return pt1;
    }
}
