class Solution {
    public static int minimumSum(String s) {
        int n = s.length();
        char[] c = s.toCharArray();

        // Step 1: make it a palindrome where forced
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            if (c[i] == '?' && c[j] == '?') continue;
            if (c[i] == '?') c[i] = c[j];
            else if (c[j] == '?') c[j] = c[i];
            else if (c[i] != c[j]) return -1;
        }

        // Step 2: work on the first half (including middle if n is odd)
        int half = (n + 1) / 2;

        // find first known letter in first half
        int first = -1;
        for (int i = 0; i < half; i++) {
            if (c[i] != '?') { first = i; break; }
        }

        // all '?' -> fill with 'a', sum is 0
        if (first == -1) return 0;

        // leading '?' take the first known letter
        for (int i = 0; i < first; i++) c[i] = c[first];

        // other '?' copy the previous letter (costs nothing extra)
        for (int i = first + 1; i < half; i++) {
            if (c[i] == '?') c[i] = c[i - 1];
        }

        // Step 3: sum over first half, doubled for the mirror
        int sum = 0;
        for (int i = 0; i + 1 < half; i++) {
            sum += Math.abs(c[i] - c[i + 1]);
        }
        return 2 * sum;
    }
}