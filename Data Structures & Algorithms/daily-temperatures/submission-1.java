class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int[] result = new int[temperatures.length];

        for(int i=0; i<temperatures.length; i++)
        {
            int temp = temperatures[i];
            while(!stack.isEmpty() && stack.peek().getKey() < temp)
            {
                Pair<Integer,Integer> top = stack.pop();
                result[top.getValue()] = i - top.getValue();
            }

            stack.push(new Pair<>(temp,i));
        }
        while(!stack.isEmpty())
        {
            Pair<Integer, Integer> top = stack.pop();
            result[top.getValue()] = 0;
        }
        return result;
    }
}
