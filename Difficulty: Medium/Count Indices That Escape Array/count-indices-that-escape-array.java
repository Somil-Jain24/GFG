import java.util.*;

class Solution {
    public int goodIndices(int[] arr) {
        int n = arr.length;

        // 0 = unvisited
        // 1 = currently visiting
        // 2 = good
        // 3 = bad
        int[] state = new int[n];

        int count = 0;

        for (int i = 0; i < n; i++) {

            if (state[i] != 0) {
                continue;
            }

            List<Integer> path = new ArrayList<>();
            int curr = i;

            while (curr >= 0 && curr < n && state[curr] == 0) {

                state[curr] = 1;
                path.add(curr);

                if (arr[curr] == 0) {
                    break;
                }

                curr = curr + arr[curr];
            }

            int finalState;

            if (curr < 0 || curr >= n) {
                // Jumped outside the array
                finalState = 2;
            } else if (arr[curr] == 0) {
                // Zero jump: bad index
                finalState = 3;
            } else if (state[curr] == 1) {
                // Cycle detected
                finalState = 3;
            } else {
                // Reached an already processed index
                finalState = state[curr];
            }

            for (int index : path) {
                state[index] = finalState;
            }
        }

        for (int s : state) {
            if (s == 2) {
                count++;
            }
        }

        return count;
    }
}