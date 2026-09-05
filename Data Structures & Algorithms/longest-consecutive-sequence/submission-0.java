class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int maxSeq = 0;
        for(int num : set) {
            if(!set.contains(num-1)) {
                int currentNum = num;
                int tempInt = 1;
                
                while(set.contains(currentNum + 1)) {
                    currentNum++;
                    tempInt++;
                }
                
                if(maxSeq < tempInt) {
                    maxSeq = tempInt;
                }
            }
        }

        return maxSeq;
    }
}