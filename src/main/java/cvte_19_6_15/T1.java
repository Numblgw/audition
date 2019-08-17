package cvte_19_6_15;

import java.util.*;

/**
 * @ClassName T1
 * @Description
 * 				###面试题###
 * 			输入一个字符串，输出该字符串中的最长的对称子串。
 * 			例如： 输入 aasdffdsap 输出 asdffdsa
 *
 *				###总结###
 *			自己大概就能想出两种方法（方法一和方法二），好像都没什么技术含量，应该是最容易想到的两种吧。。。。。。
 *			第一种比较麻烦，但我首先想到的就是这个emmmmm
 *			第二种是在写第一种的时候突然想到的，这两个也比较相似，一个是从两边向中间对比，一个是从中间像两边对比。
 *
 *			在网上找了找，大部分还是用的第二种方法，不知道还有没有更好的方法。

 * @Author Numblgw
 * @Date 2019/6/15 19:58
 */
public class T1 {

	public static void main(String[] args) {
		String s = "aawwsdfssdssfdsxxaap";
		System.out.println("输入； " + s);
		System.out.println("输出： " + method2(s));
	}

	/**
	 *
	 *			方法一
	 *
	 * 				得到相同的字符的下标，将相同的字符作为对称字符串的起始和末尾，由两端向中间逐一对比字符是否相等。
	 *
	 * 			我的基本实现思路是，对称字符串的 起始 和 末尾 的字符都是一样的，那么只需要通过运算找出一个字符串中相同的字符，并保存他们的下标。
	 * 			比如    xxasdfdsaw  这个字符串通过运算应该得到：
	 *
	 * 			x —— 0 1
	 * 			a —— 2 8
	 * 			s —— 3 7
	 * 			d —— 4 6
	 * 			f —— 5
	 * 			w —— 9
	 *
	 * 			就像这样保存每一个字符出现的下标，然后过滤掉出现次数不足两次的字符。在通过遍历剩下的字符找对称字符串。就像这样：
	 * 			a出现的下标是 2 和 8 那么就把 2 和 8 作为对称字符串的起始和末尾，从两端向中间逐一对比字符是否相等。
	 *
	 *			这个方法比较复杂，算法相关的知识好久没看了，自己也想不出什么好的方法。
	 *。
	 * @param s
	 * @return
	 */
	private static String method1(String s) {
		Objects.requireNonNull(s);
		// 通过 Map<String, List<Integer>> 记录 （字符 ——> 字符出现的下标） 这样的映射关系。
		Map<String, List<Integer>> map = new HashMap<>(s.length());
		for(int i = 0 ; i < s.length() ; i++) {
			String charAtI = String.valueOf(s.charAt(i));
			// 如果该字符没出现过，就像map中put一个新的键值对，键是该字符，值是保存该字符出现下标的List
			if(!map.containsKey(charAtI)) {
				List<Integer> list = new ArrayList<>(s.length());
				map.put(String.valueOf(charAtI), list);
				list.add(i);
			}else {
				// 如果出现过，就读取并想 List中添加一个新的下标
				List<Integer> list = map.get(charAtI);
				list.add(i);
			}
		}
		// 得到map的键集，进行遍历
		Collection<List<Integer>> values = map.values();
		// 保存当前最长的对称子串，默认初始的对称子串为空字符串
		String returnVal = "";
		for(List<Integer> list : values) {
			// 只遍历出现次数大于1的字符，只出现一次的字符不可能作为对称字符串的两端。
			if(list.size() > 1) {
				// i 和 j 代表的都是 list 的下标，并不是字符串的下标
				// 外层循环按照从左到右的顺序（list中的顺序就是该字符从左到右出现的顺序）依次将该字符作为对称字符串的首端。
				for(int i = 0 ; i < list.size() - 1 ; i++) {
					// 第二层循环依次将第一次循环中的字符的右边的字符（这里只的是同一个字符多次出现的下标）作为对称字符串的尾端。
					for(int j = i + 1 ; j < list.size() ; j++) {
						// 得到首端的字符在字符串中的下标
						int leftIndex = list.get(i);
						// 得到尾端的字符在字符串中的下标
						int rightIndex = list.get(j);
						boolean flag = true;
						// 从首端向右，尾端向左依次对比每一个字符。
						while(++leftIndex < --rightIndex) {
							if(!Objects.equals(s.charAt(leftIndex), s.charAt(rightIndex))) {
								flag = false;
								break;
							}
						}
						if(flag) {
							// 与当前最长的对称字符串比较并记录
							String substr = s.substring(list.get(i), list.get(j) + 1);
							if(substr.length() > returnVal.length()) {
								returnVal = substr;
							}
						}
					}
				}
			}
		}
		return returnVal;
	}

	/**
	 * 					方法二
	 *
	 * 			从左到右依次取第 i 个字符和第 i+1 个字符，i = 0,1,2,3.。。。。。
	 * 		先判断这两个字符是否相等，如果相等就假设对称字符串包含2n个字符（双数个），并将这两个字符作为对称字符串的中心，
	 * 		如果这两个字符不相等，那么就假设 i 是对称字符串的中心，从中心向两边逐一对比字符是否相等。
	 *
	 *
	 *		这个好像比第一个要简单一点，我也不知道为什么我第一次想了那么麻烦的一个方法。
	 *
	 *
	 * @param s
	 * @return
	 */
	private static String method2(String s) {
		Objects.requireNonNull(s);
		String returnVal = "";
		// 暂时存放当前的 第 i 个 和 第 i + 1 个字符
		String s1,s2 = null;
		// 只需要遍历到倒数第二个字符就可以了
		for(int i = 0 ; i < s.length() - 1 ; i++) {
			s1 = String.valueOf(s.charAt(i));
			s2 = String.valueOf(s.charAt(i + 1));
			if(Objects.equals(s1, s2)) {
				// 当相等时，假设对称字符串有偶数个字符，并将相等的两个作为中心
				int x = 1;
				while(i - x >= 0 && i + 1 + x < s.length()) {
					if(!Objects.equals(s.charAt(i - x), s.charAt(i + 1 + x))) {
						break;
					}
					x++;
				}
				x = x - 1;
				returnVal = s.substring(i - x, i + 2 + x).length() > returnVal.length() ? s.substring(i - x, i + 2 + x) : returnVal;
			}else {
				// 当不相等时，将第 i 个字符作为对称字符串的中心
				int y = 1;
				while(i - y >= 0 && i + y < s.length()) {
					if(!Objects.equals(s.charAt(i - y), s.charAt(i + y))) {
						break;
					}
					y++;
				}

				if((y = y - 1) > 0) {
					returnVal = s.substring(i - y, i + y + 1).length() > returnVal.length() ? s.substring(i - y, i + y + 1) : returnVal;
				}
			}
		}
		return returnVal;
	}
}
