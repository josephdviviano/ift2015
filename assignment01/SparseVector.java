/**
 * @author Prénom Nom - Matricule
 * @author Prénom Nom - Matricule
 */

public class SparseVector {

    // properties
    private Node head;    // initial node
    private int length;   // size of the full array

    public class Node {
        private Object value; // why isn't this int?
        private int index;
        private Node next; // recursively call class to get pointer to next node

        // constructor
        public Node(Object value, int index) {
            this.value = value;
            this.next = null;
            this.index = index;
        }
    }

    // constructor -- default value (passed to next constructor)
    public SparseVector() {
        this(10);
    }

    // constructor -- generate an empty vector of specified length
    public SparseVector(int length) {
        this.head = null;
        this.length = length;
    }

    // methods
    // get the value of the element at an index position
    public Object get(int index) {
        if (head == null)
            throw new RuntimeException("empty vector.");

        else if (index < 0 || index >= length)
            throw new IllegalArgumentException("index out of bounds.");

        // current node iterator
        // search list element-wise until we find the requested index, else null
        Node currentNode = head;
        while(currentNode != null) {
            if(currentNode.index == index)
                return currentNode.value;
            else
                currentNode = currentNode.next; // finds the next node object
        }
        return null; // default case
    }

    // add or update the element at an index position
    public void set(int index, Object value) {

        // make sure we're working on a valid index
        if (index < 0 || index >= length)
            throw new IllegalArgumentException('index out of bounds');

        // base case -- set first element of array with a new node object
        if (head == null) {
            head = new Node(value, index)
        }

        // if the value being set is null, remove node
        else if (value == null)
            remove(index);

        // insert set value at index, in a new node if required
        while(currentNode != null) {

            // set -- index matches
            if(currentNode.index == index) {
                currentNode.value = value;
                break;
            }

            else if(index < head.index) {
            }
        }


        // complete
    }

    // remove the element at an index position
    public void remove(int index) {
        // complete
    }

    // length of a sparse vector
    public int length() {
        return 0; // complete
    }

    // number of non-zero elements
    public int size() {
        return st.size(); //
    }
}
