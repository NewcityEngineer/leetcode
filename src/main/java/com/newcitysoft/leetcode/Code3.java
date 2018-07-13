package com.newcitysoft.leetcode;

/**
 * 3. 无重复字符的最长子串
 *
 * 给定一个字符串，找出不含有重复字符的最长子串的长度
 * 示例：
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 *
 * @author lixin.tian@renren-inc.com
 * @date 2018/7/13 14:35
 */
public class Code3 {

    /**
     * 思路：
     * 1.用一个变量存储最长子串长度
     * 2.逻辑过程
     *      输入：abcabcbb
     *      第0趟
     *          a ab abc abca
     *      第1趟
     *          b bc bca bcab
     *      第2遍
     *          c ca cab cabc
     *      第3遍
     *          a ab abc abcb
     *      第4趟
     *          b bc bcb
     *      第5趟
     *          c cb cbb
     *      第6趟
     *          b bb
     *
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        String temp = "";
        for(int i = 0; i < s.length() -1 ; i++) {
            for(int j = i; j < s.length(); j++) {
                if(temp.contains(s.charAt(j)+"")) {
                    break;
                }
                temp = s.substring(i, j+1);
                if(temp.length() > result) {
                    result = temp.length();
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().lengthOfLongestSubstring("dasdasdasf12312312313afafa"));
    }
}