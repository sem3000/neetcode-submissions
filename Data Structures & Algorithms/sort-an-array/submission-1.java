class Solution {
    public int[] sortArray(int[] nums) {
        MergeSort(nums,0,nums.length-1);
        return nums;
    }

    public void MergeSort(int[] arr, int l, int r)
    {
        if(l<r)
        {
            int m = (l+r)/2;
            MergeSort(arr,l,m);
            MergeSort(arr,m+1,r);
            Merge(arr, l, m, r);
        }
    }

    public void Merge(int[] arr, int l, int m, int r)
    {
        int s1 = m - l + 1;
        int s2 = r-m;

        int[] arr1 = new int[s1];
        int[] arr2 = new int[s2];

        for(int i=0; i<s1; i++)
            arr1[i] = arr[l+i];

        for(int i=0; i<s2; i++)
            arr2[i] = arr[m+i+1];

        int i=0, j=0, k=l;
        while(i<s1 && j<s2)
        {   
            if(arr1[i] < arr2[j])
            {
                arr[k] = arr1[i];
                i++;
            }
            else
            {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i<s1)
        {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while(j<s2)
        {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }
}