  //小扣在秋日市集选择了一家早餐摊位，一维整型数组 `staple` 中记录了每种主食的价格，一维整型数组 `drinks` 中记录了每种饮料的价格。小扣的计划
//选择一份主食和一款饮料，且花费不超过 `x` 元。请返回小扣共有多少种购买方案。
//
//注意：答案需要以 `1e9 + 7 (1000000007)` 为底取模，如：计算初始结果为：`1000000008`，请返回 `1`
//
//**示例 1：**
//>输入：`staple = [10,20,5], drinks = [5,5,2], x = 15`
//>
//>输出：`6`
//>
//>解释：小扣有 6 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
//>第 1 种方案：staple[0] + drinks[0] = 10 + 5 = 15；
//>第 2 种方案：staple[0] + drinks[1] = 10 + 5 = 15；
//>第 3 种方案：staple[0] + drinks[2] = 10 + 2 = 12；
//>第 4 种方案：staple[2] + drinks[0] = 5 + 5 = 10；
//>第 5 种方案：staple[2] + drinks[1] = 5 + 5 = 10；
//>第 6 种方案：staple[2] + drinks[2] = 5 + 2 = 7。
//
//**示例 2：**
//>输入：`staple = [2,1,1], drinks = [8,9,5,1], x = 9`
//>
//>输出：`8`
//>
//>解释：小扣有 8 种购买方案，所选主食与所选饮料在数组中对应的下标分别是：
//>第 1 种方案：staple[0] + drinks[2] = 2 + 5 = 7；
//>第 2 种方案：staple[0] + drinks[3] = 2 + 1 = 3；
//>第 3 种方案：staple[1] + drinks[0] = 1 + 8 = 9；
//>第 4 种方案：staple[1] + drinks[2] = 1 + 5 = 6；
//>第 5 种方案：staple[1] + drinks[3] = 1 + 1 = 2；
//>第 6 种方案：staple[2] + drinks[0] = 1 + 8 = 9；
//>第 7 种方案：staple[2] + drinks[2] = 1 + 5 = 6；
//>第 8 种方案：staple[2] + drinks[3] = 1 + 1 = 2；
//
//**提示：**
//+ `1 <= staple.length <= 10^5`
//+ `1 <= drinks.length <= 10^5`
//+ `1 <= staple[i],drinks[i] <= 10^5`
//+ `1 <= x <= 2*10^5` Related Topics 数组 双指针 二分查找 排序 👍 60 👎 0

  
  package com.shuzijun.leetcode.editor.en;

  import java.util.Arrays;

  public class TwoVYnGI{
      public static void main(String[] args) {
           Solution solution = new TwoVYnGI().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int breakfastNumber(int[] staple, int[] drinks, int x) {
              int[] preSum = new int[100001];
              preSum[0] = 0;
              int[] count = new int[100001];
              //统计drinks里面每个价格的数量
              for(int ans : drinks){
                  count[ans]++;
              }
              //用前缀和记录价格小于等于i的个数
              for(int i=1;i<preSum.length;i++){
                  preSum[i] = preSum[i-1] + count[i];
              }
              //结果用long型存储，会溢出
              long result = 0;
              for(int res:staple){
                  if(res < x){
                      //小于等于a的都可以，注意这里x的取值范围为2*10^5,而主食和酒的价格都为10^5.
                      int a = x - res;
                      if(a <= 100000){
                          result += preSum[a];
                      }else{
                          //这里直接加上所有的酒即可
                          result += drinks.length;
                      }
                  }
              }
              return (int)(result % 1000000007);
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }