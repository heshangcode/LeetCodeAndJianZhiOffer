package com.hs.JianZhiOffer.树;

/**
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 您需要确保二叉树可以序列化为字符串，并且可以将此字符串反序列化为原始树结构。
 * <p>
 * 样例
 * 你可以序列化如下的二叉树
 * 8
 * / \
 * 12  2
 * / \
 * 6   4
 * <p>
 * 为："[8, 12, 2, null, null, 6, 4, null, null, null, null]"
 *
 * @Author heshang.ink
 * @Date 2019/10/5 21:26
 */
public class 序列化二叉树 {
	/**
	 * 根据前序来遍历生成
	 * @param root
	 * @return
	 */
	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if (root == null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val + ",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}



	int index = 0;
	TreeNode Deserialize(String str) {
		String[] split = str.split(",");
		String s = split[index++];
		TreeNode node = null;
		if (!s.equals("#")) {
			node = new TreeNode(Integer.valueOf(s));
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		return node;
	}
}
