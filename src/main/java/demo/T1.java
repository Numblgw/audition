package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName T1
 * @Description
 *
 * 有一批订单记录，数据有订单号，入店时间，离店时间；
 *
 * 输入一个时间值A，需要在这批记录中找到符合入离店时间范围（A大于等于入店时间，并且A小于等于离店时间）内的所有记录。
 * 单次查询时间复杂度控制在O(logN)
 *
 * ※注意：订单号升序输出
 *
 * @Author Numblgw
 * @Date 2019/8/17 10:02
 */
public class T1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int count = scanner.nextInt();

		int date = scanner.nextInt();

		List<Order> list = new ArrayList<>(count);

		for(int i = 0 ; i < count ; i++) {
			int num = scanner.nextInt();
			int enterDate = scanner.nextInt();
			int exitDate = scanner.nextInt();

			if(date >= enterDate && date <= exitDate) {
				Order order = new Order(num, enterDate, exitDate);
				list.add(order);
			}
		}

		list.sort(Order::compareTo);

		if(list.size() == 0) {
			System.out.println("null");
		}else {
			list.forEach((order) -> System.out.println(order.num));
		}
	}

	static class Order implements Comparable {
		Integer num;

		Integer enterDate;

		Integer exitDate;

		public Order(int num, int enterDate, int exitDate) {
			this.num = num;
			this.enterDate = enterDate;
			this.exitDate = exitDate;
		}


		@Override
		public int compareTo(Object o) {
			if(o == null) {
				throw new NullPointerException();
			}
			if(!(o instanceof Order)) {
				throw new ClassCastException();
			}
			return this.num.compareTo(((Order)o).num);
		}
	}
}
