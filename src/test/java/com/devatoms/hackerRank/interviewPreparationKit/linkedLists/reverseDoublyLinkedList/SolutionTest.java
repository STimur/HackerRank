package com.devatoms.hackerRank.interviewPreparationKit.linkedLists.reverseDoublyLinkedList;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SolutionTest {

	private void assertDoubleLinkedListIs(DoublyLinkedListNode head, List<Integer> ints) {
		DoublyLinkedListNode currentNode = head;
		int i = 0;
		for (; currentNode != null; i++, currentNode = currentNode.next) {
			assertThat(currentNode.data, is(ints.get(i)));
		}
		assertThat(i, is(ints.size()));
	}

	private List<Integer> intList(Integer... ints) {
		return Arrays.asList(ints);
	}

	@Test
	public void null_list() {
		DoublyLinkedList list = new DoublyLinkedList();
		assertDoubleLinkedListIs(reverse(list.head), Collections.emptyList());
	}

	@Test
	public void one_element_list() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertNode(1);
		assertDoubleLinkedListIs(reverse(list.head), intList(1));
	}

	static DoublyLinkedListNode reverse(DoublyLinkedListNode head) {
		return head;
	}

	static class DoublyLinkedListNode {
		public int data;
		public DoublyLinkedListNode next;
		public DoublyLinkedListNode prev;

		public DoublyLinkedListNode(int nodeData) {
			this.data = nodeData;
			this.next = null;
			this.prev = null;
		}
	}

	static class DoublyLinkedList {
		public DoublyLinkedListNode head;
		public DoublyLinkedListNode tail;

		public DoublyLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void insertNode(int nodeData) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

			if (this.head == null) {
				this.head = node;
			} else {
				this.tail.next = node;
				node.prev = this.tail;
			}

			this.tail = node;
		}
	}
}
