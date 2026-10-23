class Solution {

    long count;

    void mergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                count += mid - i + 1;
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i - left];
        }
    }

    void inorder(Node root, ArrayList<Integer> arr) {
        if (root == null) return;

        inorder(root.left, arr);
        arr.add(root.data);
        inorder(root.right, arr);
    }

    public int pairsViolatingBST(Node root) {
        ArrayList<Integer> values = new ArrayList<>();
        inorder(root, values);

        int[] arr = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            arr[i] = values.get(i);
        }

        count = 0;
        mergeSort(arr, 0, arr.length - 1);

        return (int) count;
    }
}