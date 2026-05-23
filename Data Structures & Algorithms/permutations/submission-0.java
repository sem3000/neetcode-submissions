class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        List<Integer> notTaken = new ArrayList<>();
        
        for(int n : nums)
            notTaken.add(n);
        
        helper(new ArrayList<>(), notTaken);

        return result;
    }
    public void helper(List<Integer> taken, List<Integer> notTaken)
    {
        if(notTaken.isEmpty())
        {
            result.add(new ArrayList<>(taken));
            return;
        }
        
        for(int i=0; i<notTaken.size(); i++)
        {
            taken.add(notTaken.get(i));
            notTaken.remove(i);

            helper(taken,notTaken);

            notTaken.add(i,taken.get(taken.size()-1));
            taken.remove(taken.size()-1);
        }
    }
}
