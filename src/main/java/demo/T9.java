package demo;

/**
 * @ClassName T9
 * @Description
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * @Author Numblgw
 * @Date 2019/8/19 12:59
 */
public class T9 {
	public static void main(String[] args) {
		String s = "babad";
		System.out.println("输入：" + s);
		System.out.println("输出：" + new T9().longestPalindrome(s));
	}

	public String longestPalindrome(String s) {

		char[] chars = s.toCharArray();

		String result = "";

		for(int i = 0 ; i < chars.length ; i++) {

			int j = 1;
			while(i - j >= 0 && i + j < chars.length) {
				if(chars[i - j] != chars[i + j]) {
					break;
				}
				j++;
			}
			j--;
			// (i + j) - (i - j) + 1 = 2 * j + 1
			if(2 * j + 1 > result.length()) {
				result = s.substring(i - j, i + j + 1);
			}

			if(i + 1 < chars.length && chars[i] == chars[i + 1]) {
				j = 1;
				while(i - j >= 0 && i + j + 1 < chars.length) {
					if(chars[i - j] != chars[i + j + 1]) {
						break;
					}
					j++;
				}
				j--;

				// (i + j + 1) - (i - j) + 1 = 2 * j + 2
				if(2 * j + 2 > result.length()) {
					result = s.substring(i - j, i + j + 2);
				}
			}
		}


		return result;
	}
}
