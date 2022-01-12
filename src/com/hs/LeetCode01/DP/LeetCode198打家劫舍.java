package com.hs.LeetCode01.DP;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 思路1：回溯——》发现很多重叠子问题，然后进行，自顶向下记忆化搜索
 * 思路2：改为自顶而上的DP，
 * 动态规划方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
 * 由于不可以在相邻的房屋闯入，所以在当前位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
 * 举例来说：1 号房间可盗窃最大值为 33 即为 dp[1]=3，2 号房间可盗窃最大值为 44 即为 dp[2]=4，3 号房间自身的值为 22 即为 num=2，那么 dp[3] = MAX( dp[2], dp[1] +
 * num ) = MAX(4, 3+2) = 5，3 号房间可盗窃最大值为 55
 * https://leetcode-cn.com/problems/house-robber/solution/hua-jie-suan-fa-198-da-jia-jie-she-by-guanpengchn/
 *
 * @Author heshang.ink
 * @Date 2019/9/8 15:08
 */
public class LeetCode198打家劫舍 {
	/**
	 * 思路1：回溯——》发现很多重叠子问题，然后进行，自顶向下记忆化搜索
	 *
	 * @param nums
	 * @return
	 */
	int[] memo;

	public int rob(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		memo = new int[nums.length];
		Arrays.fill(memo, -1);
		return tryRob(nums, 0);

	}

	// 考虑抢劫nums[index...nums.length)这个范围的所有房子
	private int tryRob(int[] nums, int index) {
		if (index >= nums.length) {
			return 0;
		}

		if (memo[index] != -1) {
			return memo[index];
		}
		int res = 0;
		for (int i = index; i < nums.length; i++) {
			res = Math.max(res, nums[i] + tryRob(nums, i + 2));
		}
		memo[index] = res;
		return res;
	}

	/**
	 * 思路2：改为自顶而上的DP，
	 *
	 * @param nums
	 * @return
	 */
	public int rob2(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int[] dp = new int[nums.length + 1];
		dp[0] = 0;
		dp[1] = nums[0];

		for (int i = 2; i <= nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		}
		return dp[nums.length];
//这里如果数组大小是nums.length，后面i - 2容易越界
		/*int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}*/

		/*int prevMax = 0;
		int currMax = 0;
		for(int num:nums){
			int tmp = currMax;
			currMax = Math.max(prevMax+num,currMax);
			prevMax = tmp;
		}
		return currMax;*/
	}
}
