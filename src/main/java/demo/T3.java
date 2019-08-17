package demo;

import java.util.Scanner;

/**
 * @ClassName T3
 * @Description
 *
 * 输入一个 long 类型的数值, 求该数值的二进制表示中的1的个数 .
 *
 * @Author Numblgw
 * @Date 2019/8/17 11:15
 */
public class T3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Long l = scanner.nextLong();

		int count = 0;
		while(l != 0) {
			l = l & (l-1);
			count++;
		}
		System.out.println(count);
	}
}
