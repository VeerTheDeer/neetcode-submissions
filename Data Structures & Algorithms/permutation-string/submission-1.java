class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);

        int left = 0;
        int right = s1.length();

        while (right <= s2.length()) {
            char[] window = s2.substring(left, right).toCharArray();
            Arrays.sort(window);
            
            if (sortedS1.equals(new String(window))) {
                return true;
            }

            left++;
            right++;
        }
        
        return false;
    }
}