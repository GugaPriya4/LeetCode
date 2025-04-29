class Solution {
    public int[] runningSum(int[] nums) {
        int [] sum=new int[nums.length];
        sum[0]=nums[0];
        int summ=sum[0];
        for(int i=1;i<nums.length;i++){
            summ+=nums[i];
            sum[i]=summ;

        }
        return sum;
        
    }
}