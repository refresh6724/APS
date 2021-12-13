import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

class DoublyLinkedListNode {
	public int data;
	public DoublyLinkedListNode next;
	public DoublyLinkedListNode prev;

	public DoublyLinkedListNode(int nodeData) {
		this.data = nodeData;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkedList {
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

class DoublyLinkedListPrintHelper {
	public static void printList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
		while (node != null) {
			bufferedWriter.write(String.valueOf(node.data));

			node = node.next;

			if (node != null) {
				bufferedWriter.write(sep);
			}
		}
	}
}

class Result {

	public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {

		DoublyLinkedListNode node = llist;
		DoublyLinkedListNode insertNode = new DoublyLinkedListNode(data);
		while (node.next != null && node.data < data) {
			node = node.next;
		}
		if (node.data > data) {
			if (node.prev != null) {
				node.prev.next = insertNode;
			}
			insertNode.prev = node.prev;
			node.prev = insertNode;
			insertNode.next = node;
		} else {
			if (node.next != null) {
				node.next.prev = insertNode;
			}
			insertNode.next = node.next;
			node.next = insertNode;
			insertNode.prev = node;
		}

		while (node.prev != null) {
			node = node.prev;
		}
		return node;
	}

}

public class Solution_Inserting_a_Node_Into_a_Sorted_Doubly_Linked_List_Easy {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				DoublyLinkedList llist = new DoublyLinkedList();

				int llistCount = Integer.parseInt(bufferedReader.readLine().trim());

				IntStream.range(0, llistCount).forEach(i -> {
					try {
						int llistItem = Integer.parseInt(bufferedReader.readLine().trim());

						llist.insertNode(llistItem);
					} catch (IOException ex) {
						throw new RuntimeException(ex);
					}
				});

				int data = Integer.parseInt(bufferedReader.readLine().trim());

				DoublyLinkedListNode llist1 = Result.sortedInsert(llist.head, data);

				DoublyLinkedListPrintHelper.printList(llist1, " ", bufferedWriter);
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
