package dataStructures;

//Robby Rice, Nov 2021

//This class hopes to implement the basic features of a linked list, with a generic type.
public class DoublyLinkedList<T> {
    //Pointer that points to the first element in the linked list
    Node head;

    //Pointer that points to the last element in the linked list
    Node tail;

    //Inner node class which contains information about the Node previous and next
    public class Node<T> {
        Node next;
        Node prev;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    public void insertAtBeginning() {}

    public void deleteAtBeginning() {}

    public void insertAtEnd() {}

    public void deleteAtEnd() {}

    /*
     * Inserts Node after given key Node
     * Parameters:
     *             key - data of type T given to search and insert after
     *             data - data to be inserted after node
     * Return values:
     *             0 - value successfully entered into List
     *             1 - error finding node
     */
    public int insertAfter(T key, T data) {}

    /*
     * Deletes first node found with matching data
     * Parameters:
     *             key - data of type T given to search to delete
     * Return values:
     *             0 - value found and deleted
     *             1 - error finding node
     *            -1 - value found more than once, first instance deleted
     */
    public int deleteData(T key) {}

    public void display() {}

}
