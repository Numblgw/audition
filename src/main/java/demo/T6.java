package demo;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName T6
 * @Description
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * @Author Numblgw
 * @Date 2019/8/17 17:21
 */
public class T6 {

	public static void main(String[] args) {
		String s = "dvdf";

		System.out.println(new T6().lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		char[] chars = s.toCharArray();

		Map<Character, Integer> map = new HashMap<>(chars.length);

		int longestLength = 0;

		int size = 0;

		for(int i = 0 ; i < chars.length ; i++) {
			Integer value = map.get(chars[i]);
			if (value != null) {
				size = map.size();
				if(size > longestLength) {
					longestLength = size;
				}
				i = value;
				map.clear();
			}else {
				map.put(chars[i], i);
			}
		}
		size = map.size();
		if(size > longestLength) {
			longestLength = size;
		}

		return longestLength;
	}
}
