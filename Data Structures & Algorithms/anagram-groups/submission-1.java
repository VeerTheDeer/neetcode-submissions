class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] word = strs[i].toCharArray();
            Arrays.sort(word);
            String sortedString = new String(word);
            
            if(map.containsKey(sortedString)){
                map.get(sortedString).add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(sortedString, newList);
            }
        }

        return new ArrayList<>(map.values());
    }
}
