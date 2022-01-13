  //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1431 👎 0

  
  package com.shuzijun.leetcode.editor.en;

  import static java.util.Arrays.binarySearch;

  public class FindFirstAndLastPositionOfElementInSortedArray{
      public static void main(String[] args) {
           Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target){
            return new int[] {leftIdx, rightIdx};
        }
        return new int[] {-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
//        如果lower为true，则表示查找第一个大于或者等于target的下标，否则查找第一个大于target的下标，再减去1，得到结果
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)){
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }