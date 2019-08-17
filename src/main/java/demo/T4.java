package demo;

import java.util.*;

/**
 * @ClassName T4
 * @Description
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Numblgw
 * @Date 2019/8/17 13:47
 */
public class T4 {

	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int target = 6;

		System.out.println(Arrays.toString(twoSum(nums, target)));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, List<Integer>> map = new HashMap<>(nums.length);

		for(int i = 0 ; i < nums.length ; i++) {
			List<Integer> list = map.get(nums[i]);
			if(Objects.isNull(list)) {
				list = new LinkedList<>();
				list.add(i);
				map.put(nums[i], list);
			}else {
				list.add(i);
			}
		}

		List<Integer> result = new ArrayList<>(nums.length);

		map.forEach((key, value) -> {
			int find = target - key;
			List<Integer> findResult = map.get(find);

			if(Objects.nonNull(findResult) && value.size() > 0) {
				int arg1 = value.remove(value.size() - 1);
				if(findResult.size() > 0) {
					int arg2 = findResult.remove(findResult.size() - 1);
					result.add(arg1);
					result.add(arg2);
				}
			}
		});

		int[] result0 = new int[result.size()];

		for(int i = 0 ; i < result.size() ; i++) {
			result0[i] = result.get(i);
		}

		return result0;
	}
}
