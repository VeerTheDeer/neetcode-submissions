class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0;
        int right = heights.length - 1;
        while(left < right) {
            if(heights[left] <= heights[right]) {
                int tempArea = heights[left] * (right - left);
                if(tempArea > maxArea) maxArea = tempArea;
                left++;
            } else if(heights[left] > heights[right]) {
                int tempArea = heights[right] * (right - left);
                if(tempArea > maxArea) maxArea = tempArea;
                right--;
            }
        }

        return maxArea;
    }
}
