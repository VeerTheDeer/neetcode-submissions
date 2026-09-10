class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if(i > 0 && nums[i-1] == nums[i]) continue;
            while(left < right) {
                if(nums[i] + nums[left] + nums[right] == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left-1] == nums[left]) {
                        left++;
                    }
                } else if(nums[i] + nums[left] + nums[right] < 0) {
                    left++;

                } else if(nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }
            }
        }

        return result;
    }
}
