/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            // 把key和value值存入，getOrDefault设置对应key的value值为0
            // key是num，value是num出现的次数，如果num在map中没有出现，则设为默认值0
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[][] array = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            array[index][0] = entry.getKey();
            array[index][1] = entry.getValue();
            index++;
        }

        Arrays.sort(array, new Comparator<int[]>() {
            public int compare(int[] arr0, int[] arr1) {
                return arr1[1] - arr0[1];
            }
        });

        for (int i = 0; i < k; i++) {
            ans[i] = array[i][0];
        }

        return ans;
    }
}
// @lc code=end
