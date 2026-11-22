import java.util.HashMap;

class Solution {
    int longestSubarrayDivK(int[] arr, int k) {
        // Map to store (remainder, first index where this remainder occurred)
        HashMap<Integer, Integer> map = new HashMap<>();

        // Base case: a remainder of 0 is seen before the array starts (at index -1)
        map.put(0, -1);

        long prefixSum = 0; // Use long to prevent integer overflow
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Calculate positive remainder
            int rem = (int) (((prefixSum % k) + k) % k);

            // If this remainder has been seen before, calculate subarray length
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                maxLen = Math.max(maxLen, len);
            } else {
                // Only store the first occurrence to maximize subarray length
                map.put(rem, i);
            }
        }

        return maxLen;
    }
}