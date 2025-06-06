/**
 * 
 */

/**
 * 
 */
public class FixSinglyLinkedOrderedList
{

	// Test the Singly Linked List
	public static void main(String[] args)
	{
		SinglyLinkedListFix list = new SinglyLinkedListFix();
		list.insertNode(4);
		list.insertNode(2);
		list.insertNode(8);
		list.insertNode(3);

		list.printList();
		list.deleteNode(0);
		list.deleteNode(3);
		list.printList();


	}

}


class NodeFix {
    int data;
    NodeFix next;

    public NodeFix(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedListFix {
	NodeFix head;

    // BUGGY insertNode method
    public void insertNode(int number) {
    	NodeFix newNode = new NodeFix(number);
    	NodeFix current = head;
    	NodeFix previous = null;

        while (current != null && current.data < number) {
            previous = current;
            current = current.next;
        }
        
        if (previous == null) {
            newNode.next = head;
            head = newNode;
        } else {
        	newNode.next = current; //need this if it needs to be inserted in the middle or the end
            previous.next = newNode;

        }
    }

    // BUGGY deleteNode method
    public void deleteNode(int number) {
    	NodeFix current = head;
    	NodeFix previous = null;
    	
    	if (current == null) {
    		return;
    	} //if you delete a number that isn't in the list

        while (current != null && current.data != number) { // Bug #3: Incorrect loop termination thanks
            previous = current;
            current = current.next;
        }
        
        if (current == null) {
            return;
        }


        if (previous == null) {
            head = current.next;
        } else {
            previous.next = current.next; // Bug #5: Should be previous.next = current.next thanks
        }
    }

    public void printList() {
    	NodeFix current = head;
        while (current != null) {
            System.out.print(current.data + " → ");
            current = current.next;
        }
        System.out.println("null");
    }
}