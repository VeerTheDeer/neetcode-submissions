class Solution {

    public String encode(List<String> strs) {
        String finalStr = "";
        
        for (String str : strs) {
            finalStr += str.length() + "#" + str;
        }
        
        return finalStr;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        
        while (i < str.length()) {

            int poundIndex = str.indexOf("#", i);
            
            int length = Integer.parseInt(str.substring(i, poundIndex));
            
            int wordStart = poundIndex + 1;
            int wordEnd = wordStart + length;

            result.add(str.substring(wordStart, wordEnd));
            
            i = wordEnd;
        }
        
        return result;
    }
}
