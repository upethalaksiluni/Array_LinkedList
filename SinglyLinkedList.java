public class SinglyLinkedList {
    DltLinkedList head;

    // Method to insert elements into the linked list at the end
    public void insertAtEnd(int data) {
        DltLinkedList newNode = new DltLinkedList(data);
        if (head == null) {
            head = newNode;
        } else {
            DltLinkedList temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to insert elements into the linked list at the front
    public void insertAtFront(int data) {
        DltLinkedList newNode = new DltLinkedList(data);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert elements into the linked list at a specific position
    public void insertAtPosition(int data, int position) {
        DltLinkedList newNode = new DltLinkedList(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            DltLinkedList temp = head;
            for (int i = 0; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null) {
                newNode.next = temp.next;
                temp.next = newNode;
            } else {
                System.out.println("Position out of bounds");
            }
        }
    }

    // Method to delete the node at the front of the linked list
    public void deleteAtFront() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("List is empty, nothing to delete.");
        }
    }

    // Method to delete the node at the end of the linked list
    public void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
        } else if (head.next == null) {
            head = null;
        } else {
            DltLinkedList temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    // Method to delete the node at a specific position in the linked list
    public void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty, nothing to delete.");
        } else if (position == 0) {
            head = head.next;
        } else {
            DltLinkedList temp = head;
            for (int i = 0; i < position - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp != null && temp.next != null) {
                temp.next = temp.next.next;
            } else {
                System.out.println("Position out of bounds");
            }
        }
    }

    // Method to search for an element in the linked list
    public boolean search(int key) {
        DltLinkedList temp = head;
        while (temp != null) {
            if (temp.data == key) {
                return true; // Key found
            }
            temp = temp.next;
        }
        return false; // Key not found
    }

    // Method to display the linked list
    public void display() {
        DltLinkedList temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Insert elements into the linked list at the end
        int[] elements = {30, 85, 90, 55, 66, 45};
        for (int element : elements) {
            list.insertAtEnd(element);
        }

        // Display the linked list
        System.out.println("Linked List after inserting elements at the end:");
        list.display();

        // Insert element at the front
        list.insertAtFront(10);
        System.out.println("Linked List after inserting 10 at the front:");
        list.display();

        // Insert element at position 3
        list.insertAtPosition(50, 3);
        System.out.println("Linked List after inserting 50 at position 3:");
        list.display();

        // Delete element at the front
        list.deleteAtFront();
        System.out.println("Linked List after deleting the front element:");
        list.display();

        // Delete element at the end
        list.deleteAtEnd();
        System.out.println("Linked List after deleting the end element:");
        list.display();

        // Delete element at position 2
        list.deleteAtPosition(2);
        System.out.println("Linked List after deleting the element at position 2:");
        list.display();

        // Search for the element 100
        int key = 100;
        if (list.search(key)) {
            System.out.println("Element " + key + " found in the linked list.");
        } else {
            System.out.println("Element " + key + " not found in the linked list.");
        }
    }
}