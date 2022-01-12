package com.hs.LeetCode01.树;

import java.util.List;

/**
 * TODO
 *
 * @Author heshang.ink
 * @Date 2019/10/27 13:37
 */
public class Node {
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val,List<Node> _children) {
		val = _val;
		children = _children;
	}
};
