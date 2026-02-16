    class Solution {
        // SaikrishnaK009
        public int[] sortedSquares(int[] nums) {
            int left = 0;
            int n = nums.length;
            int right = n - 1;
            int[] result = new int[nums.length]; 

            for(int i=n-1;i>=0;i--){
                int leftSqr=nums[left]*nums[left];
                int rightSqr=nums[right]*nums[right];
                if(leftSqr>rightSqr){
                    result[i]=leftSqr;
                    left++;
                }else{
                    result[i]=rightSqr;
                    right--;
                }
            }
            return result;
        }
    }