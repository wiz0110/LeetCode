  //给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2226 👎 0


  package com.shuzijun.leetcode.editor.en;
  public class SingleNumber{
      public static void main(String[] args) {
           Solution solution = new SingleNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//          位运算的三个性质
//          1、 a 异或 0 = a;
//          2、 a 异或 a = 0;
//          因此，遍历数组中的每一个数，两个一样的数会等于0，那么落单的数就是它本身，因此得到答案
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num:nums){
            single ^= num;
        }
        return single;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }