class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        helper(nums,0,new ArrayList<>());
        return result;      
    }
    public void helper(int[] nums, int index, List<Integer> subList)
    {
        if(index == nums.length)
        {
            result.add(new ArrayList<>(subList));
            return;
        }

        subList.add(nums[index]);
        helper(nums, index+1,subList);
        subList.remove(Integer.valueOf(nums[index]));
        helper(nums,index+1,subList);
    }
}
