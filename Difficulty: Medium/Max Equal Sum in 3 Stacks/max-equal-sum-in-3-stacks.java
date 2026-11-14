import java.util.ArrayList;

class Solution {
    public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2,
                           ArrayList<Integer> s3) {
        int sum1 = 0, sum2 = 0, sum3 = 0;

        // Calculate initial total sums of all three stacks
        for (int x : s1) sum1 += x;
        for (int x : s2) sum2 += x;
        for (int x : s3) sum3 += x;

        // Pointers representing the top of each stack (index 0 is the top)
        int top1 = 0, top2 = 0, top3 = 0;
        int n1 = s1.size(), n2 = s2.size(), n3 = s3.size();

        while (true) {
            // If any stack becomes empty, the maximum equal sum is 0
            if (top1 == n1 || top2 == n2 || top3 == n3) {
                return 0;
            }

            // If sums of all three stacks are equal, we found the maximum possible sum
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }

            // Remove the top element from the stack with the largest current sum
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= s1.get(top1++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= s2.get(top2++);
            } else {
                sum3 -= s3.get(top3++);
            }
        }
    }
}
