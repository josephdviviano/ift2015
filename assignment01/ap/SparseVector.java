package hw1;

/**
 * @author Alejandro Posada - 20096748
 */

public class SparseVector {
	private Node head;			// Refers to the first node 
	private int length;	        // Max. number of nodes in the list
	
    public class Node {
    	private Object value;
    	private int index;
    	private Node next;
    	
    	// Constructor
    	public Node(Object value, int index) {
    		this.value = value;
    		this.next = null;
    		this.index = index;
    	}
    }

    public SparseVector() {
        this(10);
    }

    public SparseVector(int length) {
    	this.head = null;		// Empty linked list
        this.length = length;
    }

    // Obtenir la valeur de l'élément à la position index
    public Object get(int index) {
    	// Catch empty list error
        if (head == null)	
        	throw new RuntimeException("The vector is empty.");
        
        // Catch out of bounds error
        else if (index < 0 || index >= length)	
    		throw new IllegalArgumentException("Illegal index.");
        
    	/* Iterate through the list, compare each node's index to the requested
    	 * index and, if found, return the node's value. If not found, return null. 
    	 */
        Node currentNode = head;
        while(currentNode != null) {
        	if(currentNode.index == index)
        		return currentNode.value;
        	else
        		currentNode = currentNode.next;
        }    
        return null;
    }

    // Ajouter ou mettre à jour l'élément à la position index
    public void set(int index, Object value) {
    	// Catch out of bounds error
    	if (index < 0 || index >= length)	
    		throw new IllegalArgumentException("Illegal index");

    	// If the list is empty, insert node at head
        if (head == null) {
        	head = new Node(value, index);
        }
               
    	// Remove node   
        else if (value == null)   
    		remove(index);
    	
    	// Insert new node or put value in node given by index
    	else {	
    		Node currentNode = head;    		
    		/* Iterate through the list, find the matching index and replace the 
    		 * node's value. If it's not found, insert a new node.
    		 */
    		while(currentNode != null) {
    			// Modify value if the indices match
    			if(currentNode.index == index) {
    				currentNode.value = value;
    				break;
    				}
				// Insert before head
    			else if(index < head.index) {
					Node tempNode = head;
					head = new Node(value, index);
					head.next = tempNode;
					break;
    				}
				// Insert at the end of the list
				else if(index > currentNode.index && currentNode.next == null) {
					Node newNode = new Node(value, index);
    				currentNode.next = newNode;
    				break;
				}	
    			// Insert at non-extremum position
    			else if(currentNode.next.index > index) {
    				Node newNode = new Node(value, index);
    	    		newNode.next = currentNode.next;
    	    		currentNode.next = newNode;
    	    		break;
    			}
    			// Advance
    			else {
    				currentNode = currentNode.next;
    			}				
    		}
    	}
    }

    // Supprimer l'élément à la position index
    public void remove(int index) {        
        // If the linked list is empty
        if (head == null)	
        	throw new RuntimeException("No nodes to remove, the vector is empty.");
 
        // If the node to delete is the head and there is only one node 
        if (index == 0 && length == 1) {
        	head = null;
        	return;
        }
        
        // If the node to delete is the head and there is more than one node 
        else if (index == 0) {
        	head = head.next;
        	return;
        }
        
        else {
        	Node currentNode = head;
            Node previousNode = null;
            
            // Iterate through the list until the matching index is found
            while(currentNode != null) {
            	if(currentNode.index != index) {
            		previousNode = currentNode;
        			currentNode = currentNode.next; 	 		
            		}
            	// Delete the node
            	else {
                	previousNode.next = currentNode.next;
                	break;
            	}
            	}                		
        	}
        }      

    // Longueur du vecteur creux
    public int length() {
        return length; 
    }

    // Nombre d'éléments non nuls
    public int size() {
        int count = 0;
        Node currentNode = head;
        while (currentNode != null) {
        	count ++;
        	currentNode = currentNode.next; 
        }
        return count;
    }
    
    // Display the elements of the list as (index, value) pairs.
	public void printList() {
		Node currentNode = this.head;
		System.out.println("(index, value)");
		while(currentNode != null) {
			System.out.println("(" + currentNode.index + "," + currentNode.value + ")");
			currentNode = currentNode.next;
		}
	}
}