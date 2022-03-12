  //给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。 
//
// 请你找到这个数组里第 k 个缺失的正整数。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,3,4,7,11], k = 5
//输出：9
//解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,3,4], k = 2
//输出：6
//解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 1 <= k <= 1000 
// 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
// 
// Related Topics 数组 二分查找 👍 71 👎 0

  
  package com.shuzijun.leetcode.editor.en;

  import java.util.HashSet;
  import java.util.Set;

  public class KthMissingPositiveNumber{
      public static void main(String[] args) {
           Solution solution = new KthMissingPositiveNumber().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int findKthPositive(int[] arr, int k) {
              int max = arr[arr.length-1];
              int[]res = new int[max];
              int count = 0;
              Set<Integer> set = new HashSet<>();
              for(int i = 0; i < arr.length; i++){
                  set.add(arr[i]);
              }
              for(int i = 0; i < max; i++){
                  res[i] = i + 1;
              }
              for(int i = 0; i < max; i++){
                  if(!set.contains(res[i])){
                      count++;
                  }
                  if(count == k){
                      return res[i];
                  }
              }
              //说明k值较大
              return  k- count + max;
          }
      }

//leetcode submit region end(Prohibit modification and deletion)

  }