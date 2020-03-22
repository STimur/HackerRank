package com.devatoms.hackerRank.interviewPreparationKit.trees.heightOfBinaryTree;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	private static Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	private Node createBinaryTree(int... ints) {
		Node root = null;

		for (int i : ints)
			root = insert(root, i);

		return root;
	}

	@Test
	public void solution() {
		assertThat(height(createBinaryTree(1)), is(0));
		assertThat(height(createBinaryTree(1, 2)), is(1));
		assertThat(height(createBinaryTree(1, 2, 3)), is(2));
		assertThat(height(createBinaryTree(3, 2)), is(1));
		assertThat(height(createBinaryTree(3, 2, 1)), is(2));
		assertThat(height(createBinaryTree(7, 4, 5, 5)), is(3));
		assertThat(height(createBinaryTree(7, 4, 5, 5, 6, 6)), is(4));
	}

	public int height(Node root) {
		int leftHeight = 0;
		int rightHeight = 0;

		if (root.left != null)
			leftHeight = 1 + height(root.left);

		if (root.right != null)
			rightHeight = 1 + height(root.right);

		if (leftHeight > rightHeight)
			return leftHeight;
		return rightHeight;
	}
}
