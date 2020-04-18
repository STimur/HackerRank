package com.devatoms.hackerRank.interviewPreparationKit.linkedLists.detectCycle;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SolutionTest {

	@Test
	public void null_list() {
		assertThat(hasCycle(null), is(false));
	}

	@Test
	public void one_element_list() {
		Node node = new Node();
		assertThat(hasCycle(node), is(false));
	}

	@Test
	public void two_elements_with_cycle_list() {
		Node node1 = new Node();
		Node node2 = new Node();
		node1.next = node2;
		node2.next = node1;
		assertThat(hasCycle(node1), is(true));
	}

	@Test
	public void two_elements_without_cycle_list() {
		Node node1 = new Node();
		Node node2 = new Node();
		node1.next = node2;
		node2.next = null;
		assertThat(hasCycle(node1), is(false));
	}

	class Node {
		int data;
		Node next;
	}

	boolean hasCycle(Node head) {
		if (head == null)
			return false;

		Set<Node> set = new HashSet<>();
		Node current = head;
		while (current.next != null) {
			if (set.add(current) != true)
				return true;
			current = current.next;
		}
		return false;
	}
}
