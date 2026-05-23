class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int n: nums)
            set.add(n);

        for(int i=1; i<=nums.length+1; i++)
            if(!set.contains(i))
                return i;
    
        return 0;
    }
}