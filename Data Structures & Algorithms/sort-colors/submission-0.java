class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++)
        {
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else
                map.put(nums[i],map.get(nums[i]) + 1);
        }

        int i = 0;
        while(i < nums.length)
        {
            int zero = 0;
            int one = 0;
            int two = 0;

            if(map.containsKey(0))
                zero = map.get(0);
            while(zero > 0)
            {
                nums[i] = 0;
                i++;
                zero--;
            }

            if(map.containsKey(1))
                one = map.get(1);
            while(one > 0)
            {
                nums[i] = 1;
                i++;
                one--;
            }

            if(map.containsKey(2))
                two = map.get(2);
            while(two > 0)
            {
                nums[i] = 2;
                i++;
                two--;
            }
        }
    }
}