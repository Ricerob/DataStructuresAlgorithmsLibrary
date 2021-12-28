package dataStructures;

//Robby Rice, Nov 2021

//This class hopes to implement the basic features of a linked list, with a generic type.
public class DoublyLinkedList<T> {
    //Pointer that points to the first element in the linked list
    Node head;

    //Pointer that points to the last element in the linked list
    Node tail;

    //Count to keep track of how many nodes are in the list
    int count;

    public DoublyLinkedList(Node n) {
        head = n;
        tail = n;
        count = 1;
    }

    public DoublyLinkedList() {
        Node n = new Node();
        head = n;
        tail = n;
        count = 1;
    }

    //Inner node class which contains information about the Node previous and next
    public class Node<T> {
        Node next;
        Node prev;
        T data;

        //Empty constructor
        public Node() { this.data = null; }

        //Generic type constructor
        public Node(T data) {
            this.data = data;
        }
    }

    public void insertAtBeginning(Node<T> insert) {
        insert.next = head;
        head.prev = insert;
        head = insert;
        count++;
    }

    public void deleteAtBeginning() {
        head.next.prev = null;
        head = head.next;
        count--;
    }

    public void insertAtEnd(Node<T> insert) {
        insert.prev = tail;
        tail.next = insert;
        tail = insert;
        count++;
    }

    public void deleteAtEnd() {
        tail.prev.next = null;
        tail = tail.prev;
        count--;
    }

    /*
     * Inserts Node after given key Node
     * Parameters:
     *             key - data of type T given to search and insert after
     *             n - node to be inserted
     * Return values:
     *             0 - value successfully entered into List
     *             1 - error finding node
     */
    public int insertAfter(T key, Node n) {
        Node search = head;
        for(int i = 0; i < count; i++) {
            if(search.data == key) {
                Node after = search.next;
                search.next = n;
                after.prev = n;
                n.next = after;
                n.prev = search;
                count++;
                return 0;
            }
            search = search.next;
        }
        return 1;
    }

    /*
     * Deletes first node found with matching data.
     * Parameters:
     *             key - data of type T given to search to delete
     * Return values:
     *             0 - value found and deleted
     *             1 - error finding node
     *            -1 - value found more than once, first instance deleted
     */
    public int deleteData(T key) {
        int i = 0;
        int numFound = 0;
        Node search = head;
        while(i < count) {
            if(search.data == key && numFound == 0) {
                numFound++;
                if(search == head){ deleteAtBeginning();}
                else if(search == tail) { deleteAtEnd(); }
                else {
                    Node temp = search.next;
                    search.prev.next = temp;
                    search.next.prev = search.prev;
                    count--;
                }
            }
            else if(search.data == key && numFound != 0){
                numFound++;
            }
            search = search.next;
        }
        if(numFound == 0){
            return 1;
        }
        else if(numFound == 1) {
            return 0;
        }
        return -1;
    }

    public void display() {
        Node nodeToDis = head;
        String printLine = "";
        for(int i = 0; i < count - 1; i++){
            printLine += nodeToDis.toString() + " <--> ";
            nodeToDis = nodeToDis.next;
        }
        printLine += nodeToDis.toString();
        System.out.println(printLine);
    }

}
