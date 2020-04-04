package com.devatoms.hackerRank.interviewPreparationKit.linkedLists.insertNodeIntoSortedDoubleLinkedList;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;

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
	public void first_test() {
		DoublyLinkedListNode head = new DoublyLinkedListNode(1);
		assertDoubleLinkedListIs(sortedInsert(head, 2), intList(1, 2));
	}

	@Test
	public void second_test() {
		DoublyLinkedListNode head = new DoublyLinkedListNode(2);
		assertDoubleLinkedListIs(sortedInsert(head, 1), intList(1, 2));
	}

	@Test
	public void third_test() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertNode(1);
		list.insertNode(2);
		assertDoubleLinkedListIs(sortedInsert(list.head, 3), intList(1, 2, 3));
	}

	@Test
	public void fourth_test() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertNode(2);
		list.insertNode(3);
		assertDoubleLinkedListIs(sortedInsert(list.head, 1), intList(1, 2, 3));
	}

	@Test
	public void fifth_test() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertNode(1);
		list.insertNode(2);
		list.insertNode(3);
		assertDoubleLinkedListIs(sortedInsert(list.head, 4), intList(1, 2, 3, 4));
	}

	@Test
	public void sixth_test() {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertNode(1);
		list.insertNode(3);
		list.insertNode(4);
		list.insertNode(10);
		assertDoubleLinkedListIs(sortedInsert(list.head, 5), intList(1, 3, 4, 5, 10));
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

	static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data) {
		DoublyLinkedListNode currentNode = head;
		DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

		while (true) {
			if (currentNode.data > data) {
				if (currentNode.prev != null)
					currentNode.prev.next = newNode;
				currentNode.prev = newNode;
				newNode.next = currentNode;
				if (currentNode == head)
					return newNode;
				return head;
			}
			if (currentNode.next == null)
				break;
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
		newNode.prev = currentNode;
		return head;
	}
}
