class Solution {
    public void sortColors(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int n : nums)
        {
            map.put(n,map.getOrDefault(n,0)+1);
        }

        int i=0;
        while(i < nums.length)
        {
            int zero = map.getOrDefault(0,0);
            int one = map.getOrDefault(1,0);
            int two = map.getOrDefault(2,0);

            while(zero > 0)
            {
                nums[i] = 0;
                i++;
                zero--;
            }
            while(one > 0)
            {
                nums[i] = 1;
                i++;
                one--;
            }
            while(two > 0)
            {
                nums[i] = 2;
                i++;
                two--;
            }

        }
    }
}