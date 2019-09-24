package com.hs.JianZhiOffer;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/9/23 20:20
 */
class TreeLinkNode {
	int val;
	TreeLinkNode left = null;
	TreeLinkNode right = null;
	TreeLinkNode father = null;

	TreeLinkNode(int val) {
		this.val = val;
	}
}
public class 二叉树的下一个结点 {
	/**
	 * 思路：就是找情况的出现
	 *       F
	 *    C      E
	 *  A   D  H   G
	 *     B      M
	 *  两种情况：
	 *  1. F,他的下一个结点就是他的右子树的最左边的节点
	 *  2. D，他的父节点不为空，找到他的父节点是某个结点的左儿子
	 * @param pNode
	 * @return
	 */
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		//情况1
		if (pNode.right != null) {
			pNode = pNode.right;
			while (pNode.left != null) {
				pNode = pNode.left;
			}
			//如果没有left直接返回，记住中序遍历的顺序
			return pNode;
		}
		//有父节点，一直往上找，当前节点是父节点的右儿子的时候，直到没有父节点或者当前节点是父节点的左子树
		while (pNode.father != null) {
			if (pNode == pNode.father.left) {
				return pNode.father;
			}
			pNode = pNode.father;
		}
		return null;

	}
}
