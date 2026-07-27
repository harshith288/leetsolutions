class Solution {
    public int maxProduct(int[] nums) {
        int maxp;
        int product=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                maxp=(nums[i]-1)*(nums[j]-1);
                product=Math.max(maxp,product);
            }
        }
        return product;
    }
}