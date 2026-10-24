class Solution {
    public boolean isPossible(int n, int m, String s) {
        // code here
        
        int x_min = 0;
        int y_min = 0;        
        int x_max = 0;
        int y_max = 0;
        int x = 0;
        int y = 0;
        
        
        for(int k = 0; k<s.length(); k++)
        {
            if(s.charAt(k) == 'L')
            {
                y--;
            }
            else if(s.charAt(k) == 'R')
            {
                y++;
            }
            else if(s.charAt(k) == 'D')
            {
                x--;
            }
            else if(s.charAt(k) == 'U')
            {
                x++;
            }
            
            x_min = Math.min(x_min, x);
            x_max = Math.max(x_max, x);
            y_min = Math.min(y_min, y);
            y_max = Math.max(y_max, y);
 
        }
        
        if((x_max - x_min) < n && (y_max - y_min) < m)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}