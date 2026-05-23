class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Pair<Integer,Integer>> stack = new Stack<>();
        int maxArea = 0;
        //index,height
        for(int i=0; i<heights.length; i++)
        {
            int start = i;
            while(!stack.isEmpty() && heights[i] < stack.peek().getValue())
            {
                Pair<Integer,Integer> top = stack.pop();
                maxArea = Math.max(maxArea, (i-top.getKey()) * top.getValue());
                start = top.getKey();
            }

            stack.push(new Pair<>(start, heights[i]));
        }
        while(!stack.isEmpty())
        {
            Pair<Integer, Integer> top = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - top.getKey()) * top.getValue());
        }
        return maxArea;
    }
}
