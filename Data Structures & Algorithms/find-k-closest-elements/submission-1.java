class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int windowSum = 0;
        int minSum = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++)
        {
            windowSum += Math.abs(arr[i]-x);
            list.add(arr[i]);
        }

        minSum = windowSum;
        int l = 0;
        for(int r=k; r<arr.length; r++)
        {
            windowSum += Math.abs(arr[r]-x);
            windowSum -= Math.abs(arr[l]-x);
            l++;

            if(windowSum < minSum)
            {
                minSum = windowSum;
                list.remove(Integer.valueOf(arr[l-1]));
                list.add(arr[r]);
            }
        }

        return list;
    }
}