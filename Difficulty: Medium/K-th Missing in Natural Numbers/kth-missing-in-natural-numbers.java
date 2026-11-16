import java.util.Arrays;

class Solution {
    public int findKthSmall(int[] arr, int k) {
        Arrays.sort(arr);

        int expected = 1;

        for (int num : arr) {
            if (num < expected) {
                // Skip duplicates or non-positive numbers
                continue;
            }
            if (num == expected) {
                expected++;
            } else {
                // Numbers from 'expected' to 'num - 1' are missing
                int missingCount = num - expected;
                if (k <= missingCount) {
                    return expected + k - 1;
                }
                k -= missingCount;
                expected = num + 1;
            }
        }

        // If k-th missing element is greater than the max element in arr
        return expected + k - 1;
    }
}