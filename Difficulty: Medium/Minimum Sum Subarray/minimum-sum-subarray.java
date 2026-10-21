class Solution {
    public int minSubarraySum(int[] arr) {
        int c_min = arr[0];
        int g_min = arr[0];

        for(int i = 1;i<arr.length;i++)
        {
            c_min = Math.min(arr[i], c_min+arr[i]);
            g_min = Math.min(g_min,c_min);
        }

        return g_min;
    }
}