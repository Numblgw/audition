package cvte_19_6_15;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * @ClassName T2
 * @Description
 * 				###面试题###
 *				输入有两个参数，
 *				参数一	一组单词。
 *				参数二	一个单词。
 *
 *				要求		输出这一组单词中和参数二相似的单词。
 *
 *				相似的定义是：	单词1 可以进行 3 次以内的 ‘变换’	变成 单词2
 *
 *				变换	 指的是 插入一个字母，删除一个字母，修改一个字母
 * @Author Numblgw
 * @Date 2019/6/15 20:20
 */
public class T2 {

	public static void main(String[] args) {

	}

	/**
	 *	我真是写不下去了，想不出该怎么写，一开始还想综合处理各种可能性，后来把所有可能性细分了都不会写。。。还是去百度一下吧。
	 *
	 *	去查了一下，这个算是个经典的案例 ———— 计算两个字符串的相似度，也就是计算两个字符串的编辑距离。这个有个经典的算法，
	 *	利用了动态规划的思想，然而我已经忘了什么是动态规划了。。。。。。不说了，明天就开始啃算法。
	 *
	 * 查找这一组单词中与s相似的单词。
	 * @param words	使用List传入一组单词
	 * @param s	一个单词
	 * @return
	 */
	private static List<String> method1(List<String> words, String s) {
		Objects.requireNonNull(words);
		Objects.requireNonNull(s);
		// 总共可以修改的次数
		final int count = 3;
		List<String> result = new ArrayList<>();
		for(String item : words) {
			// 长度差
			int i = item.length() - s.length();
			// 存放修改过的字符下标
			Stack<Integer> indexStack = new Stack<>();
			if(i == 0) {
				if(Objects.equals(item, s)) {
					result.add(item);
				}
			}else if(i == 1) {
				for(int j = 0 ; j < s.length() ; j++) {
					if(!Objects.equals(item.charAt(j), s.charAt(j))) {

					}
				}
			}else if(i == 2) {

			}else if(i == 3) {

			}else if(i == -1) {

			}else if(i == -2) {

			}else if(i == -3) {

			}
		}
		return result;
	}
}
