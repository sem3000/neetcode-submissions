class MyHashSet {
    LinkedList<Integer>[] list;
    public MyHashSet() {
        list = new LinkedList[10000];
    }
    
    public void add(int key) {
        int index = key % 10000;
        if(list[index] == null)
        {
            list[index] = new LinkedList<>();
            list[index].add(key);
        }
        else
        {
            if(!list[index].contains(key))
                list[index].add(key);
        }

    }
    
    public void remove(int key) {
        int index = key % 10000;
        if(list[index] != null && list[index].contains(key))
        {
            list[index].remove(Integer.valueOf(key));
        }
    }
    
    public boolean contains(int key) {
        int index = key % 10000;
        if(list[index] != null && list[index].contains(key))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */