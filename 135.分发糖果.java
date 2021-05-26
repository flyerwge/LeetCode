/*
 * @lc app=leetcode.cn id=135 lang=java
 *
 * [135] 分发糖果
 */

// @lc code=start
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyNum = new int[len];
        int sum = 0;

        // 初始化数组为1，所有孩子至少有一个糖果
        for (int i = 0; i < len; i++) {
            candyNum[i] = 1;
        }

        // 第一次遍历，如果右边孩子分数高于左边，则右边孩子的糖果数为左边孩子糖果数+1
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyNum[i] = candyNum[i - 1] + 1;
            }
        }

        // 第二次遍历，如果左边孩子分数高于右边，
        // 并且当前糖果数不大于右边孩子，则左边孩子糖果数更新为右边孩子糖果数+1
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && candyNum[i] <= candyNum[i + 1]) {
                candyNum[i] = candyNum[i + 1] + 1;
            }
        }

        // 输出糖果数总和
        for (int i = 0; i < len; i++) {
            sum += candyNum[i];
        }

        return sum;
    }
}
// @lc code=end
