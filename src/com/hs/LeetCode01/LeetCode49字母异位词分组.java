package com.hs.LeetCode01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 思路：
 * https://leetcode-cn.com/problems/group-anagrams/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--16/
 *
 * @Author heshang.ink
 * @Date 2019/8/9 18:13
 */
public class LeetCode49字母异位词分组 {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0) {
			return null;
		}
		HashMap<String, List<String>> map = new HashMap<>();
		List<List<String>> res = new ArrayList<>();
		for (int i = 0; i < strs.length; i++) {
			char[] ca = strs[i].toCharArray();
			//排序
			Arrays.sort(ca);
			//映射到key
			String key = String.valueOf(ca);
			//添加到相应的list里
			if (!map.containsKey(key)) {
				ArrayList<String> list = new ArrayList<>();
				list.add(strs[i]);
				map.put(key, list);
			} else {
				map.get(key).add(strs[i]);
			}

		}
		return new ArrayList(map.values());
	}
}
