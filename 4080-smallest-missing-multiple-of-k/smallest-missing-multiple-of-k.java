class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int count=k;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==k){
                k=count+k;
            }
        }
        return k;
    }
}