  //给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1618 👎 0

  
  package com.shuzijun.leetcode.editor.en;
  public class MinimumWindowSubstring{
      public static void main(String[] args) {
           Solution solution = new MinimumWindowSubstring().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public String minWindow(String s, String t) {
              if (s == null || t.length() == 0){
                  return "";
              }
              // 将需要的字符个数记录下来(t)
              int[] window = new int[128];
              for (int i = 0; i < t.length(); i++){
                  window[t.charAt(i)] += 1;
              }

              int left = 0;
              int right = 0;
              int count = t.length();
              int size = Integer.MAX_VALUE;
              int start = 0;
              // 先扩大窗口，找到符合条件的字符串
              while (right < s.length()){
                  // window里 >= 0的都是需要count的， <0 的都是非必要字符
                  char c = s.charAt(right);
                  // 判断窗口是否需要当前元素，需要的话count - 1;
                  if (window[c] > 0){
                      count--;
                  }
                  // 更新得到想要的窗口
                  window[c] -= 1;
                  // 当count = 0说明需要的字符串都被找到了，左指针右移，缩小窗口，直到刚好满足count == 0
                  if (count == 0){
                      while (window[s.charAt(left)] < 0){
                          window[s.charAt(left)]++;
                          left++;
                      }
                      // 确定好新的窗口，在每个新的窗口中，找最小的窗口
                      if (right - left < size){
                          // size指向下标为确定好窗口的最后一个字符
                          size = right - left;
                          start = left;
                      }
                      // 开始下一个窗口的寻找 这时候left指向的s字串 是t的第一个字符
                      // 我们要看剩下的字串中有没有满足的, 首先让当前指向的字符不算,然后指针右移
                      window[s.charAt(left)]++;
                      left++;
                      count++;
                  }
                  right++; // 右指针不断右移,窗口不断扩大
              }
              return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size + 1);
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }