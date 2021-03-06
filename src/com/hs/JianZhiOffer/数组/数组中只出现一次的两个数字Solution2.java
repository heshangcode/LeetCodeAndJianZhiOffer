package com.hs.JianZhiOffer.数组;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 *
 * 请写程序找出这两个只出现一次的数字。
 *
 * 你可以假设这两个数字一定存在。
 *
 * 样例
 * 输入：[1,2,3,3,4,4]
 *
 * 输出：[1,2]
 * 思路：异或运算，分成两边，假设是x，y，x在左，y在右，左边的异或和就是x，右边的异或和就是y
 * 面试官想要的复杂度：时间O(N),空间O(1)
 * 在看答案前，我只知道只有一个数字出现的求法，就是把所有数组异或一下，a^a=0,a^0=a,相同的数字会被抵消成0，所以最后就剩下出现一次的数字
 *
 * 实在想不出来O(1)的空间，两个要怎么求
 *
 * 书上是这么解释的，依然用异或的做法，如果能把数组分成两组，两个只出现一次的数字分在两个数组，其余相同的数字在同一个数组里，比如题目的[1,2,3,3,4,4]，如果能分成[1,3,3]和[2,4,4] 或者 [1,3,3,4,
 * 4]和[2]就好了，这样两个数组分别求异或就是答案1和2了。
 *
 * 那么这两个数组要怎么分呢
 * 书上是这么做的，先对原数组求异或，那么结果就是1和2的异或结果011对吧，并且结果一定不为0，即结果的二进制里面至少有一个1，这个1是因为两个只出现一次的数字在这一位上不同造成的，1是001,
 * 2是010，在最右边一位不一样，所以结果的最后一位是1。
 * 因此我们可以通过最后一位是1还是0，将原数组分成两组，这样1和2必定分开，并且其他相同的数字一定在同一组，结果就是[1,3,3]和[2,4,4]；如果按照倒数第二位分，也可以分成[1,4,4]和[2,3,
 * 3]，异或后的结果是一样的，只要我们能找到原数组异或结果二进制中某一个1的位置，这里我们选择从右边开始选，为什么不从左边开始呢，因为右边方便计算
 *
 * 所以解题的步骤为
 * 1、原数组异或一下
 * 2、求异或结果中1的位置（从右开始数，从0开始）
 * 3、对原数组中的每一个数字判断内个位置上是不是1，分别异或
 *
 * 作者：脆脆鲨
 * 链接：https://www.acwing.com/solution/acwing/content/1753/
 * 来源：AcWing
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @Author heshang.ink
 * @Date 2019/10/12 16:58
 */
public class 数组中只出现一次的两个数字Solution2 {
	public int[] findNumsAppearOnce(int[] nums) {
		//1、原数组异或一下
		int sum = 0;
		for (int x : nums) {
			sum ^= x;
		}
		//求异或结果中1的位置（从右开始数，从0开始）
		int k = 0;
		while ((sum >> k & 1) != 1) {
			k++;
		}
		//这里就是把分成两边
		// 对原数组中的每一个数字判断内个位置上是不是1，分别异或
		int first = 0;
		for (int x : nums) {
			//找到一边异或和为1的
			if ((x >> k & 1) == 1) {
				first ^= x;
			}
		}
		return new int[]{first, sum ^ first};

	}
}
