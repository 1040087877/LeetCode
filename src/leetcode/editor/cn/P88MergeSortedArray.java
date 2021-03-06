//给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


package leetcode.editor.cn;

import java.util.Arrays;

//Java：合并两个有序数组
public class P88MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
        // TO TEST
    }
    

class Solution {
        //双指针法，空间复杂度 O（m）
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int[] num_copy=new int[m+n];
        int p1=0,p2=0;
        for(int i=0;p1<nums1.length && p2<nums2.length && i<m+n;i++){
            if(nums1[p1]<nums2[p2]){
                num_copy[i]=nums1[p1];
                p1++;
            }else{
                num_copy[i]=nums2[p2];
                p2++;
            }
        }
        System.arraycopy(num_copy,0,nums1,0,m+n);
    }
        //API法
    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}

}