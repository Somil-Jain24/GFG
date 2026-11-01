class Solution {
	public int maximumSubarray(int[] arr) {
		
		int n = arr.length;
		
		int normal = arr[0];
		int squared = arr[0] * arr[0];
		int ans = squared;
		
		for (int i = 1; i < n; i++) {
			int x = arr[i];
			
			int newSquared = Math.max(
			Math.max(squared + x, normal + x * x),
			x * x
			);
			
			int newNormal = Math.max(x, normal + x);
			
			squared = newSquared;
			normal = newNormal;
			
			ans = Math.max(ans, Math.max(normal, squared));
		}
		
		return ans;
		
	}
}
