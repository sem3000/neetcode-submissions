class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int maxArea = 0;

        for(int i=0; i<heights.length; i++)
        {
            int start = i;
            while(!stack.isEmpty() && stack.peek().getValue() > heights[i])
            {
                Pair<Integer, Integer> topPair = stack.pop();
                maxArea = Math.max(maxArea, (i-topPair.getKey()) * topPair.getValue());
                start = topPair.getKey();
            }
            stack.push(new Pair<>(start, heights[i]));
        }

        int length = heights.length;
        for(Pair<Integer, Integer> p : stack)
            maxArea = Math.max(maxArea,(length-p.getKey()) * p.getValue());

        return maxArea;
    }
}
