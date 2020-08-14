class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        subset(nums,ans,res,0);
        return res;
    }
    
    public void subset(int[] nums,List<Integer> ans,List<List<Integer>> res,int idx){
        ArrayList<Integer> val = new ArrayList<>(ans);
        res.add(val); 
        for(int i=idx;i<nums.length;i++){
            int num = nums[i];
            ans.add(num);
            subset(nums,ans,res,i+1);
            ans.remove(ans.size()-1);
        }
    }
}
