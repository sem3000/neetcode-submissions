class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return result;        
    }

    public void helper(int[] nums, int index, List<Integer> subList)
    {
        result.add(new ArrayList<>(subList));

        for(int i=index; i<nums.length; i++)
        {
            if(i > index && nums[i] == nums[i-1]) continue;
            
            subList.add(nums[i]);
            helper(nums, i+1, subList);
            subList.remove(subList.size()-1);
        }
    }
}
