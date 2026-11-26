class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        // code here
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int[] arr = new int[s.length()+1];
        int count = 0;
        
        for(int i = 0; i<s.length(); i++){
            if(set.contains(s.charAt(i))){
                count++;        
            }
            
            arr[i+1] = count;
        }
        
        // 1,2,2,2,2,3,3,3,4,5
        
        ArrayList<Integer> ar = new ArrayList<>();
        
        for(int[] q : queries){
            int l =q[0];
            int r = q[1];
            ar.add(arr[r+1] - arr[l]);    
            
        }
        
        return ar;
    }
}