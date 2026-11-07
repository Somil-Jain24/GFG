import java.util.*;

class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        Set<String> reserved = new HashSet<>(Arrays.asList(arr));
        Set<String> assigned = new HashSet<>();
        Map<String, Integer> suffixTracker = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for (String name : arr) {
            if (!assigned.contains(name)) {
                assigned.add(name);
                result.add(name);
            } else {
                int k = suffixTracker.getOrDefault(name, 1);
                String candidate = name + k;

                while (reserved.contains(candidate) || assigned.contains(candidate)) {
                    k++;
                    candidate = name + k;
                }

                suffixTracker.put(name, k + 1);
                assigned.add(candidate);
                result.add(candidate);
            }
        }

        return result;
    }
}