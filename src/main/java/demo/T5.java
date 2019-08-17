package demo;

/**
 * @ClassName T5
 * @Description
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 *
 *
 *
 * @Author Numblgw
 * @Date 2019/8/17 15:18
 */
public class T5 {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);


		ListNode l2 = new ListNode(5);

		System.out.println(addTwoNumbers(l1, l2));
	}



	static class ListNode {

		int val;

		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			StringBuilder result = new StringBuilder(String.valueOf(val));
			ListNode ln = this;
			while(ln.next != null) {
				ln = ln.next;
				result.append(" ---> ").append(ln.val);
			}
			return result.toString();
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if(l1 == null && l2 == null) {
			throw new NullPointerException();
		}

		ListNode result = new ListNode(0);

		ListNode ln = result;

		while(l1 != null || l2 != null) {
			if(l1 == null && l2 != null) {
				ln.val += l2.val;
				l2 = l2.next;
			}else if(l2 == null && l1 != null) {
				ln.val += l1.val;
				l1 = l1.next;
			}else if(l1 != null && l2 != null) {
				ln.val += l1.val + l2.val;
				l1 = l1.next;
				l2 = l2.next;
			}else {}
			if(l1 != null || l2 != null) {
				int nextval = 0;
				if(ln.val >= 10) {
					nextval = 1;
					ln.val -= 10;
				}
				ln.next = new ListNode(nextval);
				ln = ln.next;
			}else if(l1 == null && l2 == null && ln.val >= 10) {
				ln.val -= 10;
				ln.next = new ListNode(1);
				ln = ln.next;
			}
		}
		return result;
	}
}
