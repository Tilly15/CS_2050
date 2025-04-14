/**
 * 
 */

/**
 * 
 */
public class DoubleLinkedListLab
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		DoublyLinkedListL18 list = new DoublyLinkedListL18();

		System.out.println("Inserting at the End:");
		list.insertAtEnd(10);
		list.insertAtEnd(20);
		list.insertAtEnd(30);
		list.printForward();
		list.printBackward();

		System.out.println("\nInserting at the Head:");
		list.insertAtHead(5);
		list.insertAtHead(1);
		list.printForward();
		list.printBackward();

		System.out.println("\nDeleting Node 20:");
		list.deleteNode(20);
		list.printForward();
		list.printBackward();

		System.out.println("\nReversing the List:");
		list.reverseList();
		list.printForward();
		list.printBackward();

	}

}

class NodeL18
{
	int data;
	NodeL18 next;
	NodeL18 prev;

	public NodeL18(int data)
	{
		this.data = data;
		this.next = null;
		this.prev = null;
	}
}

class DoublyLinkedListL18
{
	NodeL18 head;

	// Insert at the end (already implemented)
	public void insertAtEnd(int data)
	{
		NodeL18 newNode = new NodeL18(data);
		if (head == null)
		{
			head = newNode;
		} else
		{
			NodeL18 temp = head;
			while (temp.next != null)
			{
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp; // Backward link
		}
	}
	
	// Print the list forward
	public void printForward()
	{
		NodeL18 current = head;
		System.out.print("Forward: ");
		while (current != null)
		{
			System.out.print(current.data + " ⇄ ");
			current = current.next;
		}
		System.out.println("null");
	}

	// Students must complete this method
	public void insertAtHead(int data)
	{
		// Implement this
		//System.out.println("Implement Insert at the Head:"); done
		NodeL18 newNode = new NodeL18(data);
		NodeL18 temp = head;
		newNode.next = temp;
		temp.prev = newNode;
		head = newNode;
	}

	// Students must complete this method
	public void deleteNode(int data)
	{
		// Implement this
		//System.out.println("Implement delete node:"); done
		NodeL18 temp = head;
		while (temp != null) {
			if (temp.data == data) {
				NodeL18 temp0 = temp.prev;
				NodeL18 temp2 = temp.next;
				temp2.prev = temp0;
				temp0.next = temp2;
			}
			temp = temp.next;
		}
	}

	// Students must complete this method
	public void reverseList()
	{
		// Implement this TODO: Fix this!
		//System.out.println("Implement reverse list:");
		NodeL18 current = head;
		NodeL18 temp;
		
		while (current != null) {
			//System.out.println("New Iteration:");
			//System.out.println(current.data);
			temp = current.next;
			current.next = current.prev;
			current.prev = temp; //swith prev and next
			head = current; //set the head as the tail
			current = current.prev; //iterate
		}
	}
	
	// Print the list backward
	public void printBackward()
	{
		// Implement this
		//System.out.println("Implement printbackward:");
		NodeL18 current = head;
		System.out.print("Backward: ");
		while (current.next != null) {
			current = current.next;
		} //find tail
		//System.out.println(current.data + " ⇄ "); //print tail
		while(current != null) {
			System.out.print(current.data + " ⇄ ");
			current = current.prev;
		}
		System.out.println("null");
		
	}
}
