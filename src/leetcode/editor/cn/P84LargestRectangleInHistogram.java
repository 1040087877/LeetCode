//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组


package leetcode.editor.cn;

import java.util.Stack;

//Java：柱状图中最大的矩形
public class P84LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new P84LargestRectangleInHistogram().new Solution();
        // TO TEST
    }
    

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculateArea(int[] heights, int start, int end) {
        //分治法
        if(start>end){
            return 0;
        }
        int minIndex=start;
        for (int i = start; i <= end; i++) {
            if(heights[minIndex]>heights[i])
                minIndex=i;
        }
        return Math.max((end-start+1)*heights[minIndex],Math.max(calculateArea(heights,start,minIndex-1),calculateArea(heights,minIndex+1,end)));
    }
    public int largestRectangleArea(int[] heights) {
        //分治法
        return calculateArea(heights, 0, heights.length - 1);
    }


    public int largestRectangleArea2(int[] heights) {
        //栈法
        Stack<Integer> stack=new Stack<Integer>();
        int maxArea=0;
        stack.push(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek()!=-1 && heights[stack.peek()]>=heights[i]){
                maxArea=Math.max(maxArea,heights[stack.pop()]*(i-stack.peek()-1));
            }
            stack.push(i);
        }

        while (stack.peek()!=-1){
            maxArea=Math.max(maxArea,heights[stack.pop()]*(heights.length-stack.peek()-1));
        }
        return maxArea;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}