class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, 0,target, new ArrayList<>());        
        return result;
    }
    public void helper(int[] nums, int index, int target, List<Integer> subList)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(subList));
            return;
        }

        for(int i=index; i<nums.length; i++)
        {
            if(i > index && nums[i] == nums[i-1]) continue;

            if(nums[i] > target) break;
            if(nums[i] <= target)
            {
                subList.add(nums[i]);
                helper(nums, i+1, target-nums[i], subList);
                subList.remove(subList.size()-1);
            }
        }
    }
}
