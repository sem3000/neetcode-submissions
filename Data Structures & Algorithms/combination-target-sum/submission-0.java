class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        helper(nums,0,target,new ArrayList<>());
        return result;
    }

    public void helper(int[] nums, int index, int target, List<Integer> subList)
    {
        if(index == nums.length)
        {
            if(target == 0)
                result.add(new ArrayList<>(subList));

            return;
        }

        if(nums[index] <= target)
        {
            subList.add(nums[index]);
            helper(nums, index, target-nums[index], subList);
            subList.remove(Integer.valueOf(nums[index]));    
        }
        helper(nums, index+1, target, subList);
        
    }
}
