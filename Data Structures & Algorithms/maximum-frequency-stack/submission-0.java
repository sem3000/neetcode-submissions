class FreqStack {
    Map<Integer, Stack<Integer>> map;
    Map<Integer, Integer> freq;
    int maxFreq;
    public FreqStack() {
        map = new HashMap<>();
        freq = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        freq.put(val,freq.getOrDefault(val, 0)+1);
        int valFreq = freq.get(val);

        maxFreq = Math.max(valFreq, maxFreq);

        if(!map.containsKey(valFreq))
        {
            Stack<Integer> s = new Stack<>();
            s.push(val);
            map.put(valFreq, s);
        }
        else
        {
            map.get(valFreq).push(val);
        }
    }
    
    public int pop() {
        int val = map.get(maxFreq).pop();
        freq.put(val, freq.get(val) - 1);
        if(map.get(maxFreq).isEmpty())
        {
            maxFreq--;
        }
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */