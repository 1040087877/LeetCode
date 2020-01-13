//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三
//元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：三数之和
public class P15ThreeSum{
    public static void main(String[] args) {
        Solution solution = new P15ThreeSum().new Solution();
        // TO TEST
        solution.threeSum(new int[]{-1,0,1,2,-1,-4});
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        List res=new ArrayList<List<Integer>>();
        //定位每一个基准
        for(int k=0;k<nums.length-2;k++){
            //边界排除
            if(nums[k]>0) break;
            if(k>0 && nums[k]==nums[k-1]) continue;

            //计算大于0 ，小于0，等于
            int i=k+1,j=nums.length-1;
            while (i<j){
                int sum=nums[k]+nums[i]+nums[j];
                if(sum<0)
                    while (i<j  && nums[i]==nums[++i]);
                else if(sum>0)
                    while (i<j && nums[j]==nums[--j]);
                else{
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k],nums[i],nums[j])));
                    while (i<j && nums[i]==nums[++i]);
                    while (i<j && nums[j]==nums[--j]);
                }
            }
        }
        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}