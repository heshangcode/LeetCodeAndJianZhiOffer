package com.hs.LeetCode.树;

import java.util.Scanner;

/**
 * https://www.nowcoder.com/questionTerminal/4b91205483694f449f94c179883c1fef?f=discussion
 *
 * @Author heshang.ink
 * @Date 2019/8/17 17:56
 */
public class 前序遍历字符串生成二叉树模板 {
	static int index = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//abc##de#g##f###
		String str = sc.next();
		TreeNode root = create(str.toCharArray());
		inorder(root);
	}

	public static TreeNode create(char[] str) {
		char c = str[index++];
		if (c=='#') {
			return null;
		}
		TreeNode node = new TreeNode(c);
		node.left = create(str);
		node.right = create(str);
		return node;
	}

	public static void inorder(TreeNode root) {
		if (root == null) {
			return;
		}
		inorder(root.left);
		System.out.print(root.val + " ");
		inorder(root.right);
	}
}
