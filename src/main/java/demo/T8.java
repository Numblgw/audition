package demo;

/**
 * @ClassName T8
 * @Description
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Author Numblgw
 * @Date 2019/8/19 10:16
 */
public class T8 {
	public static void main(String[] args) {
		int[] nums1 = {1, 2};
		int[] nums2 = {3, 4};

		System.out.println(new T8().findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int mid = (nums1.length + nums2.length) / 2;

		int[] array = new int[mid + 1];

		// x 遍历 nums1、 y 遍历 nums2
		int x = 0, y = 0;

		for(int i = 0; i < array.length; i++) {
			if(x < nums1.length && y < nums2.length) {
				if(nums1[x] <= nums2[y]) {
					array[i] = nums1[x];
					x++;
				}else {
					array[i] = nums2[y];
					y++;
				}
			} else if(x < nums1.length) {
				array[i] = nums1[x];
				x++;
			} else if(y < nums2.length) {
				array[i] = nums2[y];
				y++;
			}
		}

		double result;

		if((nums1.length + nums2.length) % 2 == 0) {
			result = (array[array.length - 1] + array[array.length - 2]) / 2.0;
		}else {
			result = array[array.length - 1];
		}

		return result;
	}
}
