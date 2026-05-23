class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        helper(1,n,k,new ArrayList<>());
        return result;
    }
    public void helper(int num, int n, int k, List<Integer> subList)
    {
        if(subList.size() == k)
        {
            result.add(new ArrayList<>(subList));
            return;
        }

        for(int i=num; i<=n; i++)
        {
            subList.add(i);
            helper(i+1,n,k,subList);
            subList.remove(subList.size()-1);
        }
    }
}