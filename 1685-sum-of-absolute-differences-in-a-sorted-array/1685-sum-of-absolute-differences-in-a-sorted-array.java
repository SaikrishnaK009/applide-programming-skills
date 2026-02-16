class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] diff = new int[len-1];
        for(int i = 0;i < len-1;i++){
            diff[i] = nums[i+1]-nums[i];
        }

        int[] forward = new int[len-1];
        int[] backward = new int[len-1];
        for(int i = 0;i < len-1;i++){
            forward[i] = diff[i]*((len-i)-1);
            backward[i] = diff[i]*(i+1);
        }

        for(int i = 1;i < len-1;i++){
            forward[i] += forward[i-1];
            backward[i] += backward[i-1];
        }

        int[] ans = new int[len];
        ans[0] = forward[len-2];
        ans[len-1] = backward[len-2];

        for(int i = 1;i < len-1;i++){
            int diff1 = forward[len-2] - forward[i-1];
            int diff2 = backward[i-1];
            ans[i] = diff1+diff2;
        }
        
        return ans;
    }
}