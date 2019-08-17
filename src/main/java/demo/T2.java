package demo;

import java.util.*;

/**
 * @ClassName T2
 * @Description
 *
 * 设计一个数据结构，实现LRU Cache的功能(Least Recently Used – 最近最少使用缓存)。它支持如下2个操作： get 和 put。
 *
 * int get(int key) – 如果key已存在，则返回key对应的值value（始终大于0）；如果key不存在，则返回-1。
 * void put(int key, int value) – 如果key不存在，将value插入；如果key已存在，则使用value替换原先已经存在的值。如果容量达到了限制，LRU Cache需要在插入新元素之前，将最近最少使用的元素删除。
 *
 * 请特别注意“使用”的定义：新插入或获取key视为被使用一次；而将已经存在的值替换更新，不算被使用。
 *
 * 限制：请在O(1)的时间复杂度内完成上述2个操作。
 *
 * @Author Numblgw
 * @Date 2019/8/17 10:35
 */
public class T2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();

		Cache cache = new Cache(n);

		String str;

		while(scanner.hasNextLine()) {
			str = scanner.nextLine();
			String[] strings = str.split(" ");
			if(Objects.equals(strings[0], "p")) {
				cache.put(Integer.valueOf(strings[1]), Integer.valueOf(strings[1]));
			}else if(Objects.equals(strings[0], "g")) {
				System.out.println(cache.get(Integer.valueOf(strings[1])));
			}
		}
	}

	static class Cache {
		Map<Integer, Integer> map;

		Queue<Integer> queue;

		int size;

		public Cache(int size) {
			this.size = size;
			map = new HashMap<>(size);
			queue = new LinkedList<>();
		}

		public int get(Integer key) {
			Integer value = map.get(key);
			if(Objects.nonNull(value)) {
				queue.remove(key);
				queue.add(key);
				return value;
			}
			return -1;
		}

		public void put(Integer key, Integer value) {
			if(map.size() < size) {
				if(map.get(key) == null) {
					queue.remove(key);
					queue.add(key);
				}
				map.put(key, value);
			}else {
				while(map.size() >= size) {
					map.remove(queue.poll());
				}
			}

		}
	}
}
