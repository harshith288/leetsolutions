class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        boolean nonzero=false;
        for(int j=0;j<nums.length;j++){
            xor^=nums[j];
            if(nums[j]!=0){
                nonzero=true;
            }
        }
        if(xor!=0){
            return nums.length;
        }
        if(nonzero){
            return nums.length-1;
        }
        return 0;
        
    }
}