class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans=new ArrayList<>();
        int min=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            if(max<nums[i])max=nums[i];
            if(min>nums[i])min=nums[i];
        }
        for(int num:nums){
            map.put(num,1);
        }
        for(int i=min+1;i<max;i++){
            if(!map.containsKey(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}