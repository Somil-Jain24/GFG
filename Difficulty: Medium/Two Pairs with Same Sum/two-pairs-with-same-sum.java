import java.util.*;

class Solution {
    public ArrayList<Integer> findPairs(int[] arr) {
        int n = arr.length;
        // Maps: Sum -> First (lexicographically smallest) pair [a, b]
        Map<Integer, int[]> map = new HashMap<>();
        int[] best = null;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];

                if (!map.containsKey(sum)) {
                    // Store the earliest pair [i, j] for this sum
                    map.put(sum, new int[]{i, j});
                } else {
                    int[] first = map.get(sum);
                    int a = first[0], b = first[1];

                    // Ensure all 4 indices are distinct
                    if (a != i && a != j && b != i && b != j) {
                        int[] candidate = {a, b, i, j};
                        if (best == null || isSmaller(candidate, best)) {
                            best = candidate;
                        }
                    }
                }
            }
        }

        if (best == null) {
            return new ArrayList<>(Arrays.asList(-1, -1, -1, -1));
        }
        return new ArrayList<>(Arrays.asList(best[0], best[1], best[2], best[3]));
    }

    private boolean isSmaller(int[] cand, int[] best) {
        for (int k = 0; k < 4; k++) {
            if (cand[k] != best[k]) {
                return cand[k] < best[k];
            }
        }
        return false;
    }
}