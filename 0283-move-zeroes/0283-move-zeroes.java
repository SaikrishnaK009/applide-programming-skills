class Solution {
    public void moveZeroes(int[] nums) {
        int l = 0;
        for (int num: nums) {
            if (num!= 0) {
                nums[l++] = num;
            }
        }
        
        while (l < nums.length) {
            nums[l++] = 0;
        }
    }
}