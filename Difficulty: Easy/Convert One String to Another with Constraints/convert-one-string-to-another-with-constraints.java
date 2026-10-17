class Solution {
    public boolean isItPossible(String s1, String s2) {
        // code here
        if(s1.length() != s2.length())
        {
            return false;
        }
        int count_a = 0;
        int count_b = 0;
        for(int i = 0;i<s1.length();i++)
        {
            if(s2.charAt(i) == 'A' && s1.charAt(i) == '#')
            {
                count_a += 1;
            }
            else if(s2.charAt(i) == '#' && s1.charAt(i) == 'A')
            {
                if(count_a != 0)
                {
                    count_a -= 1;
                }
                else
                {
                    return false;
                }
            }
            else if(s1.charAt(i) == 'A' && s2.charAt(i) == 'B' || s1.charAt(i) == 'B' && s2.charAt(i) == 'A')
            {
                return false;
            }
        }

        for(int i = s1.length()-1;i>=0;i--)
        {
            if(s2.charAt(i) == 'B' && s1.charAt(i) == '#')
            {
                count_b += 1;
            }
            else if(s2.charAt(i) == '#' && s1.charAt(i) == 'B')
            {
                if(count_b != 0)
                {
                    count_b -= 1;
                }
                else
                {
                    return false;
                }
            }
        }

        return (count_a == 0 && count_b == 0);
    }
};